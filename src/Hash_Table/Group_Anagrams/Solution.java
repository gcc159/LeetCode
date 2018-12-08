package Hash_Table.Group_Anagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();

        for(String str:strs){
            String hash=generateHash(str);
            List<String> result=map.getOrDefault(hash,new ArrayList<>());
            result.add(str);
            map.put(hash,result);

        }
        List<List<String>> res=new ArrayList<>();
        res.addAll(map.values());
        return res;
    }

    private String generateHash(String str){
        int []counts=new int[26];
        for(int i=0;i<str.length();i++){
            counts[str.charAt(i)-'a']++;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<26;i++)
            if(counts[i]>0){
                sb.append((char)('a'+i));
                sb.append(counts[i]);
            }
        return sb.toString();
    }
}
