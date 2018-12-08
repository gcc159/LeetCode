package Binary_Search.Divide_Two_Integers;

public class Solution {
    public int divide(int dividend, int divisor) {
        boolean negtive=true;
        if(dividend==0) return 0;
        if((dividend>=0&&divisor>0)||(dividend<=0)&&divisor<0) {
            negtive = false;

        }
        if(dividend==Integer.MIN_VALUE) {
            if(divisor==1) return dividend;
            else if(divisor==-1) return Integer.MAX_VALUE;
            if(divisor==Integer.MIN_VALUE) return 1;
        }
        if(divisor==Integer.MIN_VALUE) return 0;

        if(dividend!=Integer.MIN_VALUE&&Math.abs(divisor)>Math.abs(dividend)) return 0;
        if(divisor==1) return dividend;
        if(divisor==-1) return -dividend;
        if(dividend==Integer.MIN_VALUE){
            if (divisor < 0)
                divisor = (~divisor) + 1;
            int res = 0;
            while (dividend <= 0) {
                dividend += divisor;
                ++res;
            }

            if (negtive)
                return -(res - 1);
            else
                return res - 1;
        }
        else {
            if (dividend < 0)
                dividend = (~dividend) + 1;
            if (divisor > 0)
                divisor = (~divisor) + 1;

            int res = 0;
            if (dividend == -divisor) res = 2;
            else {
                while (dividend > 0) {
                    dividend += divisor;
                    ++res;
                }
            }
            if (negtive)
                return -(res - 1);
            else
                return res - 1;

        }
    }

    public static void main(String[] args){
        Solution solution=new Solution();
        System.out.println(solution.divide(Integer.MIN_VALUE,-2));
    }
}
