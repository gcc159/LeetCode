package BasicAlgorithm.String;

import BasicAlgorithm.Sort.Insertion;

public class MSD {
    private static int R=256;
    private static final int M=15;
    private static String[] aux;
    private static int charAt(String s,int d){
        if(d<s.length()) return s.charAt(d);
        else return -1;
    }

    public static void sort(String[] a,int lo ,int hi,int d){
        if(hi<=lo+M){
            Insertion.sort(a,lo,hi,d);
            return ;
        }

        int[] count= new int[R+2];
        for(int i=lo;i<=-hi;i++) //计算频率
            count[charAt(a[i],d)+2]++;

        for(int r=0;r<R+1;r++)
            count[r+1]+=count[r];

        for(int i=lo;i<=hi;i++) //数据回写，根据索引找到不同分类的字符串所应当在的相对顺序
            aux[count[charAt(a[i],d)+1]++]=a[i];

        for(int i=lo;i<=hi;i++)
            a[i]=aux[i-lo];

        //排序完成后，count[r]已经指向r+1的第一个类别的字符串开始的索引。
        //排除所有已经字符串小于d的字符，继续排序
        for(int r=0;r<R;r++)
            sort(a,lo+count[r],lo+count[r+1]-1,d+1);

    }
}
