package Backtracking.Restore_IP_Addresses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        return backtracking(new ArrayList<String>(),s);
    }


    private List<String> backtracking(List<String> previous,String current){
        List<String> res=new ArrayList<>();
        //没有字符，则直接返回，不符合要求
        if(current.length()==0) return res;
        if(previous.size()==3){
            //位于末尾的位置，如果数字位数过大或者开头为0则返回
            if(current.length()>=4||(current.charAt(0)=='0'&&current.length()>1)) return res;
            int currentInt=Integer.parseInt(current);
            if(currentInt<=255){
                StringBuilder sb=new StringBuilder();
                for(int i=0;i<3;i++){
                    sb.append(previous.get(i));
                    sb.append('.');
                }
                sb.append(currentInt);
                res.add(sb.toString());
            }
        }else{
            //位于IP地址中部，如果具有零开头，那么这一位只能够为0
            if(current.charAt(0)=='0'){
                previous.add("0");
                res.addAll(backtracking(previous,current.substring(1)));
                previous.remove(previous.size()-1);
            }else
                //不然查找1-3位的子串
            for(int endIndex=1;endIndex<=Math.min(current.length(),3);endIndex++){
                int currentInt=Integer.valueOf(current.substring(0,endIndex));
                if(currentInt<=255){
                    previous.add(current.substring(0,endIndex));
                    res.addAll(backtracking(previous,current.substring(endIndex)));
                    previous.remove(previous.size()-1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        Solution solution=new Solution();
        List<String> res=solution.restoreIpAddresses("010010");
        System.out.println(res);
    }
}
