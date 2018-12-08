package BasicAlgorithm.Sort;

public class Merge  {

    public static void merge(int[] a,int low,int mid,int high){
        int i=low;
        int j=mid+1;
        int[] aux=new int[a.length];
        for(int k=low;k<=high;k++)
            aux[k]=a[k];
        for(int k=low;k<high;k++){
            if(i>mid) a[k]=aux[j++];
            else if(j>high) a[k]=aux[i++];
            else if(a[i]>a[j]) a[k]=aux[j++];
            else a[k]=aux[i++];

        }
    }

    private static void upsort(int[] a,int low,int high){

        if(high<low) return;

        int mid=(low+high)/2;
        upsort(a,low,mid);
        upsort(a,mid+1,high);
        merge(a,low,mid,high);
    }

    private static void downsort(int[] a){
        for(int size=1;size<a.length;size+=size)
            for(int low=0;low<a.length-size;low+=size*2)
                merge(a,low,low+size-1,Math.min(low+size*2,a.length-1));
    }
}
