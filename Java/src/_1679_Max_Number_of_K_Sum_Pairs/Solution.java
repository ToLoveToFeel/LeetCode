package _1679_Max_Number_of_K_Sum_Pairs;

import java.util.HashMap;
import java.util.Map;

/**
 * Date: 2020/12/7 10:38
 * Content:
 * 执行用时：82 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：48.2 MB, 在所有 Java 提交中击败了100.00%的用户
 */
public class Solution {

    public int maxOperations(int[] nums, int k) {

        // 第一步：统计数字出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 第二步：计算得到结果
        int res = 0;
        for (int num : nums) {
            int x = num;
            int y = k - num;
            if (map.containsKey(x) && map.containsKey(y)) {  // 只有nums中同时存在 x和 y才更新
                int t = Math.min(map.get(x), map.get(y));
                if (x == y)
                    t /= 2;
                res += t;
                map.put(x, map.get(x) - t);
                map.put(y, map.get(y) - t);
            }
        }

        return res;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};
        int k = 5;
        System.out.println((new Solution()).maxOperations(nums, k));
    }
}
