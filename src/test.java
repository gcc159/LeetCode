import java.util.HashSet;
import java.util.Set;

public class test
{
    public boolean isPalindrome(String s) {
        if(s.equals("")) return true;
        Set<Character> set=new HashSet<>();
        for(char start='a';start<='z';start++)
            set.add(start);
        for(char start='A';start<='Z';start++)
            set.add(start);
        for(char start='0';start<='9';start++)
            set.add(start);
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++)
            if(set.contains(s.charAt(i))){
                sb.append(s.charAt(i));
            }

        if(sb.toString().toLowerCase().equals(sb.reverse().toString().toLowerCase())) return true;
        else return false;

    }

    public static void main(String[] args){
        test t=new test();
        t.isPalindrome("A man, a plan, a canal: Panama");
    }
}
