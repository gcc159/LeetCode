package String.Basic_Calculator_II;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Solution {
    public int calculate(String s) {
        s=s.trim();
        Stack<Integer> oprandsStack=new Stack<>();
        Stack<Character> opsStack=new Stack<>();
        Set<Character> opsSet=new HashSet<>();
        opsSet.add('+');
        opsSet.add('-');
        opsSet.add('*');
        opsSet.add('/');
        int currentIndex=0;
        boolean isops=false;
        boolean needCal=false;
        while(currentIndex<s.length()){
            if(s.charAt(currentIndex)==' '){
                currentIndex++;
                continue;
            }
            if(!isops) {
                int endIndex = currentIndex;
                while (endIndex<s.length()&&s.charAt(endIndex) >= '0' && s.charAt(endIndex) <= '9') {
                    endIndex++;
                }
                int currentoprand = Integer.parseInt(s.substring(currentIndex, endIndex ));
                currentIndex = endIndex;
                isops=true;
                if(needCal){
                    int anotherOprand=oprandsStack.pop();
                    Character ops=opsStack.pop();
                    oprandsStack.push(cal(anotherOprand,currentoprand,ops));
                    needCal=false;
                }else
                    oprandsStack.push(currentoprand);
            }else{
                char currentOps=s.charAt(currentIndex);
                opsStack.push(currentOps);
                if(currentOps=='*'||currentOps=='/')
                    needCal=true;
                else
                    needCal=false;
                currentIndex++;
                isops=false;
            }
        }
        Stack<Integer> RoprandsStack=new Stack<>();
        Stack<Character> RopsStack=new Stack<>();
        while(!oprandsStack.isEmpty())
            RoprandsStack.push(oprandsStack.pop());
        while(!opsStack.isEmpty())
            RopsStack.push(opsStack.pop());
        while(!RopsStack.isEmpty()){
            int first=RoprandsStack.pop();
            int two=RoprandsStack.pop();
            char ops=RopsStack.pop();
            RoprandsStack.push(cal(first,two,ops));
        }

        return RoprandsStack.peek();
    }

    private int cal(int a,int b,char ops){
        switch (ops){
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '*':
                return a*b;
            case '/':
                return a/b;
        }
        return -1;
    }


    public static void main(String[] args){
        Solution solution=new Solution();
        solution.calculate("0-2147483647");
    }
}
