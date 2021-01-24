package _0169_Majority_Element;

import java.util.HashMap;
import java.util.Map;

/**
 * Date: 2020/8/24 15:41
 * Content: 使用Map统计
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
public class Solution2 {

    public int majorityElement(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) map.put(nums[i], 1);
            else map.put(nums[i], map.get(nums[i]) + 1);
        }
        int res = nums[0];
        int maxCount = map.get(nums[0]);
        for (Integer num : map.keySet()) {
            int count = map.get(num);
            if (count > maxCount) {
                res = num;
                maxCount = count;
            }
        }
        return res;
    }


    public static void main(String[] args) {

        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println((new Solution2()).majorityElement(nums));
    }
}
