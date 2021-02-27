package _0659_Split_Array_into_Consecutive_Subsequences;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Date: 2020/12/4 10:11
 * Content: 哈希表 + 最小堆
 * https://leetcode-cn.com/problems/split-array-into-consecutive-subsequences/solution/fen-ge-shu-zu-wei-lian-xu-zi-xu-lie-by-l-lbs5/
 * <p>
 * 时间复杂度：O(n*log n)，其中 n 是数组的长度，因为对于每个数据，都要更新堆
 * 空间复杂度：O(n)，其中 n 是数组的长度
 * <p>
 * 执行用时：85 ms, 在所有 Java 提交中击败了12.12%的用户
 * 内存消耗：40 MB, 在所有 Java 提交中击败了38.78%的用户
 */
public class Solution {

    public boolean isPossible(int[] nums) {

        if (nums.length < 3) return false;

        // 第一步：统计以某个数字为结尾的序列的长度
        // (连续序列结尾的数字，以该数字为结尾的序列的长度(可能存在多个))
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {  // 如果不存在以 num 结尾的连续序列，则添加
                map.put(num, new PriorityQueue<>());
            }

            if (map.containsKey(num - 1)) {  // 如果包含 num-1，则将 num 加入到以 num-1 为结尾的最短的连续序列中
                int length = map.get(num - 1).remove();  // 获取以 num-1 为结尾的最短的连续序列的长度
                if (map.get(num - 1).isEmpty()) {  // 出队后，如果此时没有了以 num-1 为结尾的连续序列，可以删除这个键值对
                    map.remove(num - 1);
                }
                map.get(num).add(length + 1);
            } else {  // 说明不包含以 num-1 为结尾的序列，此时直接将以 num 结尾连续序列长度设为1
                map.get(num).add(1);
            }
        }

        // 第二步：判断是否有些序列的长度小于3
        Set<Map.Entry<Integer, PriorityQueue<Integer>>> set = map.entrySet();
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : set) {
            PriorityQueue<Integer> queue = entry.getValue();
            if (queue.peek() < 3) {  // 最小堆栈顶元素，代表以某个数据为结尾的连续序列（可能存在多个）的最短长度
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

//        int[] nums = {1, 2, 3, 3, 4, 5};  // true
        int[] nums = {1, 2, 3, 4, 4, 5};  // false
        System.out.println((new Solution()).isPossible(nums));
    }
}
