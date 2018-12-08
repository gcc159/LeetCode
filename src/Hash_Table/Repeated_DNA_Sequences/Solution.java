package Hash_Table.Repeated_DNA_Sequences;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res=new ArrayList<>();
        HashSet<Integer> set=new HashSet<>();
        HashSet<Integer> resSet=new HashSet<>();
        for(int i=0;i<=s.length()-10;i++){
            String subStr=s.substring(i,i+10);
            Integer hash=generateHash(subStr);
            if(set.contains(hash)){
                if(!resSet.contains(hash)){
                    res.add(subStr);
                    resSet.add(hash);
                }
            }

            else set.add(hash);
        }

        return res;
    }

    private int generateHash(String s){
        int result=0;
        for(int i=0;i<s.length();i++){
            result<<=2;
            switch (s.charAt(i)){
                case 'A':
                    result |=0;
                    break;
                case 'C':
                    result |=1;
                    break;
                case 'G':
                    result |=2;
                    break;
                case 'T':
                    result |=3;
                    break;
                    default:
                        break;
            }
        }
        return result;
    }
}
