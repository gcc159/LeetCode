package DynamicProgramming.Best_Time_to_Buy_and_Sell_Stock_with_Cooldown;

import java.util.Arrays;

public class Solution {
    public int maxProfit(int[] prices) {
        int []sell,buy;
        sell=new int [prices.length];
        buy=new int [prices.length];
        buy[0]=-prices[0];
        sell[0]=0;
        buy[1]=Math.max(-prices[1],buy[0]);
        sell[1]=Math.max(sell[0],buy[0]+prices[1]);

        for(int i=2;i<prices.length;i++){
            buy[i]=Math.max(buy[i-1],sell[i-2]-prices[i]);
            sell[i]=Math.max(sell[i-1],buy[i-1]+prices[i]);
        }
        return sell[prices.length-1];
    }

    public static void main(String[] args){
        int []prices={1,2,4};
        Solution solution=new Solution();
        solution.maxProfit(prices);
    }
}
