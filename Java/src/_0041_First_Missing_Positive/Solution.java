package _0041_First_Missing_Positive;

import java.util.HashSet;

/**
 * 1、由于有时间复杂度O(n)的要求，所以只能进行遍历，不能进行排序。
 * 2、首先把数组中的正数都拿出来，放到集合里，则数组中没有出现的最小整数
 * 只可能比数组中正数的个数n小，所以可以从1到n遍历一下，看一下数字是否在
 * 集合里即可知道缺失的最小整数。
 */
public class Solution {

    public int firstMissingPositive(int[] nums) {

        if (nums.length == 0) return 1;

        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (num <= 0) continue;
            hashSet.add(num);
        }

        if (hashSet.size() == 0) return 1;

        int res = hashSet.size() + 1;
        for (int i = 1; i <= hashSet.size(); i++)
            if (!hashSet.contains(i)) {
                res = i;
                break;
            }

        return res;
    }

    public static void main(String[] args) {

        int[] nums = {3, 4, -1, 1};  // 2
        System.out.println((new Solution()).firstMissingPositive(nums));
    }
}
