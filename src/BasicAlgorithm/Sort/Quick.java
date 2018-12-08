package BasicAlgorithm.Sort;

import java.util.Random;

public class Quick {
    public static void sort(Comparable[] a){
        sort(a,0,a.length-1);
    }
    private static void sort(Comparable[] a,int lo,int hi){
        if(hi<=lo) return ;
        int j=partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }

    private static int partition(Comparable[] a,int lo ,int hi){
        int i=lo,j=hi+1;
        Comparable v = a[lo];
        while(true){
            while(a[++i].compareTo(v)<0) if(i==hi) break;
            while(a[--j].compareTo(v)>0) if(j==lo) break;
            if(i>=j) break;
            Comparable temp=a[i];
            a[i]=a[j];
            a[j]=temp;
        }
        Comparable temp=a[j];
        a[j]=a[lo];
        a[lo]=a[j];
        return j;
    }

}
