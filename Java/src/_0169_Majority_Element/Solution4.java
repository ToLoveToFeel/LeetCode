package _0169_Majority_Element;

/**
 * Date: 2020/8/24 15:41
 * Content: 分治
 *      时间复杂度：O(n^logn)
 *      空间复杂度：O(logn)
 */
public class Solution4 {
    private int countInRange(int[] nums, int num, int left, int right){
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (nums[i] == num)
                count++;
        }
        return count;
    }

    private int majorityElementRec(int[] nums, int left, int right) {
        if (left == right)
            return nums[left];

        int mid = (right-left)/2 + left;
        int leftMajorityNum = majorityElementRec(nums, left, mid);
        int rightMajorityNum = majorityElementRec(nums, mid+1, right);

        if (leftMajorityNum==rightMajorityNum)
            return leftMajorityNum;

        int leftCount = countInRange(nums, leftMajorityNum, left, mid);
        int rightCount = countInRange(nums, rightMajorityNum, mid+1, right);

        return leftCount > rightCount ? leftMajorityNum :rightMajorityNum;
    }


    public int majorityElement(int[] nums) {
        return majorityElementRec(nums, 0, nums.length - 1);
    }


    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println((new Solution4()).majorityElement(nums));
    }
}
