package BasicAlgorithm.String;

/**
 * 三向字符串切分排序算法，可以在最坏情况时有较好的性能，同时不需要辅助数组。
 */
public class Quick3string {
    private static int charAt(String s,int d){
        if(d<s.length()) return s.charAt(d);
        else return -1;
    }

    public static void sort(String[] a){
        sort(a,0,a.length-1,0);
    }

    private static void sort(String[] a,int lo,int hi,int d){
        if(hi<=lo) return ;
        int lt=lo,gt=hi;
        int v=charAt(a[lo],d);
        int i=lo+1;
        while(i<=gt){
            int t=charAt(a[i],d);
            if(t<v) exch(a,lt++,i++);
            else if(t>v) exch(a,i,gt--);
            else i++;

        }

        sort(a,lo,lt-1,d);
        if(v>=0) sort(a,lt,gt,d+1);
        sort(a,gt+1,hi,d);
    }
}
