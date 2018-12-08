package Array._Plus_One;

public class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            if (digits[i] > 9) {

                    digits[i]=digits[i]%10;
                if (i ==0) {
                    int[] res=new int[digits.length+1];
                    res[0]=1;
                    System.arraycopy(digits,0,res,1,digits.length);
                    return res;
                }

            }else
                break;
        }
        return digits;
    }
}
