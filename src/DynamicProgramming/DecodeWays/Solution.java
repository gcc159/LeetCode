package DynamicProgramming.DecodeWays;

public class Solution {

    public int numDecodings(String s) {
        if(s.length()==0) return 0;
        int dp[]=new int[s.length()];
        if(s.charAt(0)!='0')
            dp[0]=1;
        else {
            dp[0]=0;
            return 0;
        }
        if(s.length()==1) return dp[0];
        if(s.charAt(1)!='0')
            dp[1]=1+(((s.charAt(0)-'0')*10+(s.charAt(1)-'0'))<=26?1:0);
        else
            if((s.charAt(0)-'0')>=3) return 0;
            dp[1]=1;
        if(s.length()==2) return dp[1];
        for(int i=2;i<s.length();i++){
            if(s.charAt(i)!='0'){
                dp[i]=dp[i-1];
                if(s.charAt(i-1)!='0')
                    dp[i]+=((s.charAt(i-1)-'0')*10+(s.charAt(i)-'0'))<=26?dp[i-2]:0;
            }else{
                if((s.charAt(i-1)-'0')<=2&&(s.charAt(i-1)-'0')>0){
                    dp[i]=dp[i-2];
                }else return 0;
            }

        }

        return dp[s.length()-1];
    }
}
