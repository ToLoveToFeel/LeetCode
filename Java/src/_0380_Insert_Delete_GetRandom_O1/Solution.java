package _0380_Insert_Delete_GetRandom_O1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Date: 2021/5/29 16:40
 * 执行用时：13 ms, 在所有 Java 提交中击败了49.28%的用户
 * 内存消耗：42.7 MB, 在所有 Java 提交中击败了94.09%的用户
 */
public class Solution {

    static class RandomizedSet {

        HashMap<Integer, Integer> hash = new HashMap<>();
        List<Integer> nums = new ArrayList<>();

        /** Initialize your data structure here. */
        public RandomizedSet() {

        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int x) {
            if (!hash.containsKey(x)) {
                nums.add(x);
                hash.put(x, nums.size() - 1);
                return true;
            }
            return false;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int x) {
            if (hash.containsKey(x)) {
                int y = nums.get(nums.size() - 1);
                int px = hash.get(x), py = hash.get(y);
                int t = nums.get(px); nums.set(px, nums.get(py)); nums.set(py, t);
                t = px; hash.put(x, py); hash.put(y, t);
                nums.remove(nums.size() - 1);
                hash.remove(x);
                return true;
            }
            return false;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return nums.get(new Random().nextInt(nums.size()));
        }
    }

    public static void main(String[] args) {

        RandomizedSet r = new RandomizedSet();
        System.out.println(r.insert(1));  // true
        System.out.println(r.remove(2));  // false
        System.out.println(r.insert(2));  // true
        System.out.println(r.getRandom());  // 2
        System.out.println(r.remove(1));  // true
        System.out.println(r.insert(2));  // false
        System.out.println(r.getRandom());  // 2
    }
}
