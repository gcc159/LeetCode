package Two_Points.Longest_Word_in_Dictionary_through_Deleting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public String findLongestWord(String s, List<String> d) {
        d.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()!=o2.length())
                    return -Integer.compare(o1.length(),o2.length());
                else
                    return o1.compareTo(o2);
            }
        });

        for(int i=0;i<d.size();i++){
            int length=LCS(s,d.get(i));;
            if(length==d.get(i).length())
                return d.get(i);
        }

        return null;
    }


    private int LCS(String a,String b){
        char[] aChars=a.toCharArray();
        char[] bChars=b.toCharArray();
        int i=0;
        for(int k=0;k<aChars.length&&i<bChars
        .length;k++)
            if(aChars[k]==bChars[i]) i++;

         return i;
    }

    public static void main(String[] args){
        String a="abpcplea";
        String[] list={"ale","apple","monkey","plea"};
        Solution solution=new Solution();
        solution.findLongestWord(a, Arrays.asList(list));
    }
}
