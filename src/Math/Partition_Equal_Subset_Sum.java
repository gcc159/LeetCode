package Math;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Partition_Equal_Subset_Sum {
    public boolean canPartition(int[] nums) {
        int sum=0;
        Arrays.sort(nums);
        int[] times=new int[101];
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            times[nums[i]]++;
        }
        if(sum%2==1) return false;
        Set<Integer> set= new TreeSet<>();
        set.add(0);
        for(int i=1;i<=100;i++){
            if(times[i]>0) {
                Set<Integer> currentSet = new TreeSet<>();
                for (Integer integer : set) {
                    for (int j = 1; j <= times[i]; j++) {
                        int current = integer + j * i;
                        if (current == sum / 2) return true;
                        currentSet.add(integer + j * i);
                    }
                }
                set.addAll(currentSet);

            }
        }
        return false;
    }
}
