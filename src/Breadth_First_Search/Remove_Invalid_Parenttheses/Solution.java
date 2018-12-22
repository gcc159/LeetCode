package Breadth_First_Search.Remove_Invalid_Parenttheses;

import java.util.*;

public class Solution {
    class Possible implements Iterator<List<Integer>> {
        int n;
        Stack<Integer> indexStack=new Stack<>();
        List<Integer> indexList;
        boolean isInitial=false;
        public Possible(int n, List<Integer> index) {
            this.n = n;
            this.indexList = index;
            for(int i=0;i<n;i++)
                indexStack.push(i);
            isInitial=true;
        }


        @Override
        public boolean hasNext() {
            if(isInitial) {
                isInitial=false;
                return true;
            }
            while(!indexStack.empty()&&
                    (indexStack.peek()+1==indexList.size()
                            ||indexList.size()-indexStack.peek()-2<n-indexStack.size()))
                indexStack.pop();

            if(indexStack.isEmpty()) return false;
            indexStack.push(indexStack.pop()+1);
            for(int i=indexStack.peek()+1;indexStack.size()<n&&i<indexList.size();i++)
                indexStack.push(i);
            return indexStack.size()==n;

        }

        @Override
        public List<Integer> next() {
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<n;i++)
                list.add(indexList.get(indexStack.get(i)));
            return list;
        }
    }

    public List<String> removeInvalidParentheses(String s) {

        List<Integer> targetList=null;
        List<Integer> leftIndex=new ArrayList<>();
        List<Integer> rightIndex=new ArrayList<>();
        Set<String> res=new HashSet<>();
        int misLeft=0;
        int misRight=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                misLeft++;
                leftIndex.add(i);
            }else
            if(s.charAt(i)==')'){
                rightIndex.add(i);
                if(misLeft>0) misLeft--;
                else{
                    misRight++;

                }
            }
        }

        if(misLeft!=0&&misRight!=0) {
            Possible leftPossible=new Possible(misLeft,leftIndex);
            while (leftPossible.hasNext()) {
                List<Integer> left = leftPossible
                        .next();
                Possible rightPossible = new Possible(misRight, rightIndex);
                while (rightPossible.hasNext()) {
                    List<Integer> right = rightPossible.next();
                    add(s,left,right,res,misLeft,misRight);
                }

            }
        }else if(misLeft!=0){
            Possible leftPossible=new Possible(misLeft,leftIndex);

            while (leftPossible.hasNext()) {
                List<Integer> left = leftPossible
                        .next();
                add(s,left,new ArrayList<>(),res,misLeft,misRight);
            }
        }else if(misRight!=0){
            Possible rightPossible = new Possible(misRight, rightIndex);

            while (rightPossible.hasNext()) {
                List<Integer> right = rightPossible
                        .next();
                add(s,new ArrayList<>(),right,res,misLeft,misRight);
            }
        }else{

            res.add(s);
        }

        return new ArrayList<>(res);

    }

    private void add(String s,List<Integer> left,List<Integer> right,
                     Set<String> res,int misLeft,int misRight){
        StringBuilder sb=new StringBuilder();
        int leftMis=0;
        int rightMis=0;
        int leftHas=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                if(leftMis<left.size()&&i==left.get(leftMis)) leftMis++;
                else{
                    leftHas++;
                    sb.append(s.charAt(i));
                }

            }else if(s.charAt(i)==')'){
                if(rightMis<right.size()&&i==right.get(rightMis)) rightMis++;
                else{
                    leftHas--;

                    if(leftHas<0)
                        break;
                    sb.append(s.charAt(i));
                }
            }else
                sb.append(s.charAt(i));
        }
        if(sb.length()==s.length()-(misLeft+misRight)&&leftHas==0)
            res.add(sb.toString());
    }


    public static void main(String[] args){
        Solution solution=new Solution();

        solution.removeInvalidParentheses("()(()((");
    }



}
