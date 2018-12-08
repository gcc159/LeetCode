package String.Reverse_Word_in_a_String;

public class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        StringBuilder sb=new StringBuilder();
        boolean ismulti=false;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                if(ismulti)
                    continue;
                else{
                    ismulti=true;
                }
            }else
                ismulti=false;
            sb.append(s.charAt(i));

        }
        String news=sb.toString();
        String[] all=news.split(" ");
        StringBuilder res=new StringBuilder();
        for(int i=all.length-1;i>0;i--){
            if(!all[i].equals("")){
                res.append(all[i]);

                res.append(" ");
            }
        }
        res.append(all[0]);
        return res.toString();
    }
}
