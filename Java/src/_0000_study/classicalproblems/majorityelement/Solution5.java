package _0000_study.classicalproblems.majorityelement;

/**
 * Date: 2020/8/24 15:41
 * Content: 摩尔投票法
 * Wiki：Boyer–Moore majority vote algorithm
 * 论文地址：https://link.springer.com/chapter/10.1007%2F978-94-011-3488-0_5
 * 论文名称：MJRTY—A Fast Majority Vote Algorithm
 * 时间复杂度：O(n^logn)
 * 空间复杂度：O(logn)
 */
public class Solution5 {

    public int majorityElement(int[] nums) {

        int res = nums[0];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                res = nums[i];
            }

            if (res == nums[i])
                count++;
            else
                count--;
        }

        return res;
    }


    public static void main(String[] args) {

//        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int[] nums = {3, 2, 3};
        System.out.println((new Solution5()).majorityElement(nums));
    }
}
