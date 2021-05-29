package _0381_Insert_Delete_GetRandom_O1_Duplicates_allowed;

import java.util.*;

/**
 * Date: 2021/05/29 17:20
 * 执行用时：17 ms, 在所有 Java 提交中击败了32.42%的用户
 * 内存消耗：45.1 MB, 在所有 Java 提交中击败了62.34%的用户
 */
public class Solution {

    static class RandomizedCollection {

        // (数字, (该数字出现在list中的索引集合))
        private final Map<Integer, Set<Integer>> hash = new HashMap<>();
        private final List<Integer> nums = new ArrayList<>();

        /** Initialize your data structure here. */
        public RandomizedCollection() {
        }

        /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
        public boolean insert(int x) {
            Set<Integer> set = hash.get(x);
            if (set == null) set = new HashSet<>();
            nums.add(x);  // 添加数据
            set.add(nums.size() - 1);  // 添加索引
            hash.put(x, set);  // 更新map
            return set.size() == 1;
        }

        private void swap(List<Integer> list, int i, int j) {
            int t = list.get(i);
            list.set(i, list.get(j));
            list.set(j, t);
        }

        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int x) {
            if (!hash.containsKey(x) || hash.get(x).isEmpty()) return false;

            int y = nums.get(nums.size() - 1);
            int px = hash.get(x).iterator().next(), py = nums.size() - 1;
            int t = nums.get(px); nums.set(px, nums.get(py)); nums.set(py, t);
            hash.get(x).remove(px); hash.get(x).add(py);
            hash.get(y).remove(py); hash.get(y).add(px);
            nums.remove(nums.size() - 1);
            hash.get(x).remove(py);
            return true;
        }

        /** Get a random element from the collection. */
        public int getRandom() {
            return nums.get((new Random()).nextInt(nums.size()));
        }
    }

    public static void main(String[] args) {

        RandomizedCollection t = new RandomizedCollection();
        System.out.println(t.insert(0));
        System.out.println(t.remove(0));
        System.out.println(t.insert(-1));
        System.out.println(t.remove(0));
        System.out.println(t.getRandom());
    }
}

