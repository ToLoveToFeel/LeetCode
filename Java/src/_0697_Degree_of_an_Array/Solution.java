package _0697_Degree_of_an_Array;

import java.util.HashMap;
import java.util.Map;

/**
 * Date: 2021/2/20 9:46
 * Content: 哈希表记录：(数值，(出现次数，第一次出现的位置，最后一次出现的位置))
 * 执行用时：16 ms, 在所有 Java 提交中击败了86.49%的用户
 * 内存消耗：42.8 MB, 在所有 Java 提交中击败了36.18%的用户
 */
public class Solution {

    public int findShortestSubArray(int[] nums) {

        Map<Integer, int[]> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!hash.containsKey(nums[i])) hash.put(nums[i], new int[]{1, i, i});
            else {
                hash.get(nums[i])[0]++;
                hash.get(nums[i])[2] = i;
            }
        }

        int max = 0, res = 0;
        for (Map.Entry<Integer, int[]> entry : hash.entrySet()) {
            int[] v = entry.getValue();
            if (max < v[0]) {
                max = v[0];
                res = v[2] - v[1] + 1;
            } else if (max == v[0]) {
                res = Math.min(res, v[2] - v[1] + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).findShortestSubArray(new int[]{1, 2, 2, 3, 1}));  // 2
    }
}
