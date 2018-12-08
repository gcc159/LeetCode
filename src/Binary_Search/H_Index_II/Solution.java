package Binary_Search.H_Index_II;

public class Solution {
    public int hIndex(int[] citations) {
        if(citations.length==0) return 0;
        int start=0;
        int end=citations.length-1;
        int res=0;
        while(start<end){
            int mid=(start+end)/2;
            if(citations[mid]>(end-mid+1+res)){
                res+=end-mid+1;
                end=mid-1;

            }else if(citations[mid]<(end-mid+1+res)){
                start=mid+1;
            }else{
                start=end=mid;
                break;
            }
        }
        int length=citations.length-1-start+1;
        if(length<=citations[start]) return length;
        if(start==citations.length-1) return Math.min(1,citations[start]);
        else return Math.min(length-1,citations[start+1]);
    }
}
