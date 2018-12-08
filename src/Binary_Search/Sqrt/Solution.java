package Binary_Search.Sqrt;

public class Solution {
    public int mySqrt(int x) {
        double d_x=x;
        if(x==0) return 0;
        if(x<=3) return 1;


        double e= 1e-15;
        double c=d_x;
        double y=(c/d_x+d_x)/2;
        while(Math.abs(d_x-y)>e){
            d_x=y;
            y=(c/d_x+d_x)/2;
        }
        return (int)d_x;
    }

    public static void main(String[] args){
        Solution solution=new Solution();
        solution.mySqrt(8192);
    }
}
