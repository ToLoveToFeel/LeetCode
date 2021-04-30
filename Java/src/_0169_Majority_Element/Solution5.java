package _0169_Majority_Element;

/**
 * Date: 2020/8/24 15:41
 * Content: 摩尔投票法
 * Wiki：Boyer–Moore majority vote algorithm
 * 论文地址：https://link.springer.com/chapter/10.1007%2F978-94-011-3488-0_5
 * 论文名称：MJRTY—A Fast Majority Vote Algorithm
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class Solution5 {

    public int majorityElement(int[] nums) {

        int r = 0, c = 0;
        for (int x : nums) {
            if (c == 0) {
                r = x;
                c = 1;
            } else if (r == x) c++;
            else c--;
        }
        return r;
    }


    public static void main(String[] args) {

//        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int[] nums = {3, 2, 3};
        System.out.println((new Solution5()).majorityElement(nums));
    }
}
