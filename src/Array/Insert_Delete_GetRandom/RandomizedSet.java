package Array.Insert_Delete_GetRandom;

import java.util.*;

public class RandomizedSet {

    List<Integer> hashList;
    Map<Integer,Integer> map;


    /** Initialize your data structure here. */
    public RandomizedSet() {
        hashList=new ArrayList<>();
        map=new HashMap<>();

    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        int hash=((Integer)val).hashCode();
        if(!map.keySet().contains(hash)){
            hashList.add(hash);
            map.put(hash,val);
            return true;
        }else
            return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        int hash=((Integer)val).hashCode();
        if(!map.keySet().contains(hash)) {
            hashList.remove((Integer) hash);
            map.remove(hash);
            return true;

        }else
            return false;

    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random rand=new Random();
        int index=rand.nextInt(hashList
        .size());
        return map.get(hashList.get(index));
    }
}
