package Divide_and_Conquer.Different_Ways_to_Add_Parentheses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> opsPos=new ArrayList<>();
        for(int i=1;i<input.length();i++){
            if(!(input.charAt(i)>='0'&&input.charAt(i)<='9')){

                opsPos.add(i);
            }
        }
        List<Integer> res=new ArrayList<>();
        if(opsPos.size()==0){
            res.add(Integer.parseInt(input));
            return res;
        }else{
            for(int i=0;i<opsPos.size();i++){
                int pivot=opsPos.get(i);
                List<Integer> first=diffWaysToCompute(input.substring(0,pivot));
                List<Integer> second=diffWaysToCompute(input.substring(pivot+1));
                for(int a:first)
                    for(int b:second)
                        switch (input.charAt(pivot)){
                            case '-':
                                res.add(a-b);
                                break;
                            case '+':
                                res.add(a+b);
                                break;
                            case '*':
                                res.add(a*b);
                                break;
                        }
            }
            return res;
        }

    }



}
