package _0659_Split_Array_into_Consecutive_Subsequences;

import java.util.*;

/**
 * Date: 2020/12/4 10:52
 * Content:
 * https://leetcode-cn.com/problems/split-array-into-consecutive-subsequences/solution/tan-xin-suan-fa-jian-cha-shu-zu-neng-fou-bei-fen-w/
 * <p>
 * 执行用时：46 ms, 在所有 Java 提交中击败了20.54%的用户
 * 内存消耗：40.3 MB, 在所有 Java 提交中击败了26.87%的用户
 */
public class Solution2 {

    public boolean isPossible(int[] nums) {

        if (nums.length < 3)
            return false;

        // 第一步：用一个哈希表统计每个元素出现的次数
        Map<Integer, Integer> map = new HashMap<>();  // (数据，次数)
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 定义一个哈希表记录最长的子序列
        Map<Integer, Integer> tail = new HashMap<>();
        for (int num : nums) {

            int count = map.getOrDefault(num, 0);
            if (count <= 0) {  // 当前元素已经用完，直接跳过
                continue;
            }

            // 说明 count > 0
            if (tail.getOrDefault(num - 1, 0) > 0) {
                // 前面还有数字，可以构成以 num 结尾的子序列
                map.put(num, count - 1);
                tail.put(num - 1, tail.get(num - 1) - 1);  // 删除一个当前以num-1为结尾的子序列
                tail.put(num, tail.getOrDefault(num, 0) + 1);  // 添加一个以num结尾的子序列

            } else if (map.getOrDefault(num + 1, 0) > 0 &&
                    map.getOrDefault(num + 2, 0) > 0) {
                // 前面无数字构成子序列后，判断能不能跟后面的构成子序列
                map.put(num, count - 1);
                map.put(num + 1, map.get(num + 1) - 1);
                map.put(num + 2, map.get(num + 2) - 1);
                tail.put(num + 2, tail.getOrDefault(num + 2, 0) + 1);  // 添加一个以 num+2 为结尾的子序列

            } else {
                return false;  // 前后不能构成子序列直接返回 false
            }
        }

        return true;
    }

    public static void main(String[] args) {

//        int[] nums = {1, 2, 3, 3, 4, 5};  // true
        int[] nums = {1, 2, 3, 4, 4, 5};  // false

        System.out.println((new Solution2()).isPossible(nums));
    }
}
