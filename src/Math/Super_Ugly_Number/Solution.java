package Math.Super_Ugly_Number;

import java.util.Arrays;

public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int []indexs=new int[primes.length];
        Arrays.fill(indexs,0);

        int []res=new int[n+1];
        res[0]=1;
        int counter=0;
        while(counter<n){
            int min=Integer.MAX_VALUE;

            int mini=-1;

            for(int i=0;i<primes.length;i++){
                if(primes[i]*res[indexs[i]]<min){
                    min=primes[i]*res[indexs[i]];
                    mini=i;
                }
            }
            res[++counter]=min;
            indexs[mini]++;
            for(int i=0;i<primes.length;i++)
                if(primes[i]*res[indexs[i]]==res[counter]){
                    indexs[i]++;
                }
        }
        return res[n-1];
    }


    public static void main(String[] args){

        int n=12;
        int []primes={2,7,13,19};

        Solution solution=new Solution();
        solution.nthSuperUglyNumber(n,primes);
    }
}
