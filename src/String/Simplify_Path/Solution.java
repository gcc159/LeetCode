package String.Simplify_Path;

import java.util.Stack;

public class Solution {
    public String simplifyPath(String path) {
        StringBuilder sb=new StringBuilder();
        boolean ismulti=false;
        for(int i=0;i<path.length();i++){
            if(path.charAt(i)=='/'){
                if(ismulti)
                    continue;
                else{
                    ismulti=true;
                }
            }else
                ismulti=false;
            sb.append(path.charAt(i));

        }
        String newPath=sb.toString();
        String[] alldetail=newPath.split("/");
        Stack<String> currentPath=new Stack<>();
        int upload=0;
        for(int i=0;i<alldetail.length;i++){
            switch (alldetail[i]){
                case "..":{
                    if(currentPath.isEmpty())
                        upload--;

                    else
                        currentPath.pop();
                }
                break;
                case ".":
                case "":{

                }
                break;
                default:{
                    if(upload==0){
                        currentPath.push(alldetail[i]);
                    }else
                        upload++;
                }

            }
        }
        String[] allremain=currentPath.toArray(new String [0]);
        if(upload<0||currentPath.isEmpty()) return "/";
        StringBuilder res=new StringBuilder();
        for(int i=0;i<allremain.length;i++){
            res.append("/");
            res.append(allremain[i]);

        }
        return res.toString();


    }

    public static void main(String[] args){
        Solution solution=new Solution();
        solution.simplifyPath("/a/../../b/../c//.//");
    }

}
