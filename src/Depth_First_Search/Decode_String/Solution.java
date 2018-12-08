package Depth_First_Search.Decode_String;

import java.util.Stack;

public class Solution {
    public String decodeString(String s) {
        StringBuilder sb=new StringBuilder();
        int start=0;
        int end=0;
        while(start<s.length()){
            if(s.charAt(start)>='0'&&s.charAt(start)<='9'){
                while(s.charAt(end)>='0' && s.charAt(end)<='9') end++;
                int times=Integer.valueOf(s.substring(start,end));
                int count=1;
                start=end+1;
                end=start;
                while(count>0){
                    if(s.charAt(end)==']') count--;
                    if(s.charAt(end)=='[') count++;
                    end++;
                }
                String res=decodeString(s.substring(start,end-1));
                for(int i=0;i<times;i++)
                    sb.append(res);
                start=end;
                //end=start;
            }else{
                while(end<s.length()&&(s.charAt(end)>= 'a'&&s.charAt(end)<= 'z'||s.charAt(end)>= 'A'&&s.charAt(end)<= 'Z')) end++;
                sb.append(s.substring(start,end));
                start=end;
                end=start;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        String s="3[a]2[b4[F]c]";
        Solution solution=new Solution();
        System.out.println(solution.decodeString(s));
    }


}
