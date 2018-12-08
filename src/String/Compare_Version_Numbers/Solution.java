package String.Compare_Version_Numbers;

public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] first=version1.split("\\.");
        String[] second =version2.split("\\.");
        int length1=first.length;
        int length2=second.length;
        while(Integer.parseInt(first[length1-1])==0&&length1>1) length1--;
        while(Integer.parseInt(second[length2-1])==0&&length2>1) length2--;
        for(int i=0;i<Math.min(length1,length2);i++){
            int current1=Integer.parseInt(first[i]);
            int current2=Integer.parseInt(second[i]);
            if(current1>current2) return 1;
            if(current2>current1) return -1;
        }
        if(length1>length2) return 1;
        else if(length1<length2) return -1;
        return 0;
    }

    public static void main(String[] args){
        Solution solution=new Solution();
        solution.compareVersion("1","0");
    }
}
