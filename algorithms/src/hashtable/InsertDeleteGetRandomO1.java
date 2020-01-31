package hashtable;

import common.Flip;
import common.FlippedSchoolType;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Flip(value= FlippedSchoolType.HASH_TABLE)
public class InsertDeleteGetRandomO1 {
    class RandomizedSet {
        Set<Integer> num;
        int size;

        /** Initialize your data structure here. */
        public RandomizedSet() {
            num = new HashSet<>();
            size = 0;
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if(num.contains(val))
                return false;

            num.add(val);
            size++;
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if(!num.contains(val))
                return false;

            num.remove(val);
            size--;
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            int rdVal = new Random().nextInt(size);
            int index = 0;
            for(Integer n : num) {
                if(index == rdVal) return n;
                index++;
            }
            return Integer.MIN_VALUE;
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}
