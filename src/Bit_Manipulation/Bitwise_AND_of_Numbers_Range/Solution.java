package Bit_Manipulation.Bitwise_AND_of_Numbers_Range;

public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if(m==n) return m;
        int res=n-m;
        int remain=0;
        while(res!=0){
            res>>>=1;
            remain+=1;

            n>>>=1;
            m>>>=1;
        }

        res=m&n;
        for(int i=0;i<remain;i++)
            res<<=1;
        return res;
    }
}
