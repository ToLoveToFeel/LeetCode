package _0659_Split_Array_into_Consecutive_Subsequences;

import java.util.*;

/**
 * Date: 2020/12/4 10:52
 * Content: 贪心：如果x可以接在某个已经存在的序列中，则接上去；否则新开一个(长度至少为3)
 * 执行用时：32 ms, 在所有 Java 提交中击败了74.31%的用户
 * 内存消耗：40.1 MB, 在所有 Java 提交中击败了15.66%的用户
 */
public class Solution2 {

    Map<Integer, Integer> tail = new HashMap<>();  // 记录每个子序列的结尾

    private int get(Map<Integer, Integer> map, int x) {
        return map.getOrDefault(x, 0);
    }

    public boolean isPossible(int[] nums) {

        // 第一步：用一个哈希表统计每个元素出现的次数
        Map<Integer, Integer> map = new HashMap<>();  // (数据，次数)
        for (int x : nums) map.put(x, map.getOrDefault(x, 0) + 1);

        for (int x : nums) {
            int t = map.getOrDefault(x, 0);
            if (t <= 0) continue;
            if (get(tail, x - 1) > 0) {  // 前面还有数字，可以构成以 x 结尾的子序列
                map.put(x, t - 1);
                tail.put(x - 1, tail.get(x - 1) - 1);  // 删除一个当前以x-1为结尾的子序列
                tail.put(x, tail.getOrDefault(x, 0) + 1);  // 添加一个以x结尾的子序列
            } else if (get(map, x + 1) > 0 && get(map, x + 2) > 0) {
                map.put(x, t - 1);
                map.put(x + 1, map.get(x + 1) - 1);
                map.put(x + 2, map.get(x + 2) - 1);
                tail.put(x + 2, tail.getOrDefault(x + 2, 0) + 1);  // 添加一个以 x+2 为结尾的子序列
            } else return false;  // 前后不能构成子序列直接返回 false
        }
        return true;
    }

    public static void main(String[] args) {

//        int[] nums = {1, 2, 3, 3, 4, 5};  // true
        int[] nums = {1, 2, 3, 4, 4, 5};  // false

        System.out.println((new Solution2()).isPossible(nums));
    }
}
