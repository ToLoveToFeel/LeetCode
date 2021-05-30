package _0398_Random_Pick_Index;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Date: 2021/5/30 14:44
 * 执行用时：95 ms, 在所有 Java 提交中击败了11.84%的用户
 * 内存消耗：51.7 MB, 在所有 Java 提交中击败了5.05%的用户
 */
public class Solution {

    HashMap<Integer, List<Integer>> hash = new HashMap<>();
    Random r = new Random();

    public Solution(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (!hash.containsKey(nums[i])) hash.put(nums[i], new ArrayList<>());
            hash.get(nums[i]).add(i);
        }
    }

    public int pick(int target) {
        return hash.get(target).get(r.nextInt(Integer.MAX_VALUE) % hash.get(target).size());
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 3, 3};
        System.out.println((new Solution(nums)).pick(3));
        System.out.println((new Solution(nums)).pick(3));
        System.out.println((new Solution(nums)).pick(3));
    }
}
