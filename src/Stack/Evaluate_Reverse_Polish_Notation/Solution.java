package Stack.Evaluate_Reverse_Polish_Notation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        Set<String> oprationSet=new HashSet<>();
        oprationSet.add("+");
        oprationSet.add("-");
        oprationSet.add("*");
        oprationSet.add("/");
        Stack<Integer> operandStack=new Stack<>();

        for(int i=0;i<tokens.length;i++){
            if(oprationSet.contains(tokens[i])){
                int op1=operandStack.pop();
                int op2=operandStack.pop();
                int res=0;
                switch (tokens[i]){
                    case "+":
                        res=op2+op1;
                        break;
                    case "-":
                        res=op2-op1;
                        break;
                    case "*":
                        res=op2*op1;
                        break;
                    case "/":
                        res=op2/op1;
                        break;
                }
                operandStack.push(res);
            }else{
                int op=Integer.valueOf(tokens[i]);
                operandStack.push(op);
            }

        }
        return operandStack.peek();
    }


}
