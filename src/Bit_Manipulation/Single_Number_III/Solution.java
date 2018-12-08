package Bit_Manipulation.Single_Number_III;

public class Solution {
    public int[] singleNumber(int[] nums) {
        int res=0;
        for(int i=0;i<nums.length;i++){
            res^=nums[i];
        }
        int position=0;
        int temp=res;
        int current=0;
        while(current!=1){
            current=temp&1;
            position++;
            temp>>=1;
        }
        int firstres=0;
        for(int i=0;i<nums.length;i++){
            int cur=(nums[i]>>position)&1;
            if(cur==1)
                firstres^=nums[i];
        }
        int []result=new int[2];
        result[0]=firstres;
        result[1]=res^firstres;
        return result;



    }
}
