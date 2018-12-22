package Array.Median_of_Two_Sorted_Arrays;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int []temp;

        if(nums1.length>nums2.length){
            temp=nums1;
            nums1=nums2;
            nums2=temp;
        }
        int m=nums1.length;
        int n=nums2.length;
        int left=0,right=m-1;
        int i=0;
        while(left<right){
            i=(left+right)/2;
            int j=(m+n)/2-i;
            if(i==0||j==0){

            }
            if(nums1[i]>=nums2[j-1]&&nums1[i-1]<=nums2[j]){
                break;
            }else{
                if(nums1[i-1]>nums2[j]) right=i-1;
                else
                    left=i+1;

            }
        }
        if(left==right) i=left;
        int j=(m+n)/2-i;
        double res=(Math.max(nums1[i-1],nums2[j-1])+Math.min(nums1[i],nums2[j]))/2.0;
        return res;

    }
}
