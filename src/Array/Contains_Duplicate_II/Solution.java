package Array.Contains_Duplicate_II;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Item[] items=new Item[nums.length];
        for(int i=0;i<nums.length;i++){
            items[i]=new Item(nums[i],i);
        }

        Arrays.sort(items,new MyComparator());
        for(int i=1;i<nums.length;i++)
            if(items[i].val==items[i-1].val&&items[i].index-items[i-1].index<=k)
                return true;
        return false;
    }


    class Item{
        int val;
        int index;

        public Item(int val, int index) {
            this.val = val;
            this.index = index;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Item item = (Item) o;
            return val == item.val &&
                    index == item.index;
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, index);
        }
    }

    class MyComparator implements Comparator<Item> {
        @Override
        public int compare(Item o1, Item o2) {
            if(o1.val<o2.val) return 1;
            else if(o1.val>o2.val) return -1;
            else {
                return Integer.compare(o1.index,o2.index);
            }

        }
    }
}
