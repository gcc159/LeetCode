package Hash_Table.Isomorphic_String;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> smap=new HashMap<>();
        Map<Character,Character> tmap=new HashMap<>();
        for(int i=0;i<s.length();i++){
            Character cht= smap.get(s.charAt(i));
            if(cht==null) {

                cht=t.charAt(i);
                smap.put(s.charAt(i), cht);
            }

            Character chs=tmap.get(t.charAt(i));

            if(chs==null){
                chs=s.charAt(i);
                tmap.put(t.charAt(i),chs);
            }
            if(cht!=t.charAt(i)||chs!=s.charAt(i))
                return false;

        }
        return true;
    }

    public static void main(String[] args){
        Solution solution=new Solution();
        solution.isIsomorphic("ab","ca");
    }
}
