package _0075_Sort_Colors;

/**
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 * 三路快排
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：37.1 MB, 在所有 Java 提交中击败了79.42%的用户
 */
public class Solution2 {

    public void sortColors(int[] nums) {

        // nums[0...zero] == 0, nums[zero+1, i) == 1, nums[two...n-1] == 2
        int zero = -1;
        int two = nums.length;
        int i = 0;

        while (i < two) {
            if (nums[i] == 1)
                i++;
            else if (nums[i] == 2)
                swap(nums, --two, i);
            else {  // nums[i] == 0
                swap(nums, ++zero, i++);
            }
        }

//        for (int i = 0; i < two; ) {
//            if (nums[i] == 1)
//                i++;
//            else if (nums[i] == 2)
//                swap(nums, --two, i);
//            else {
//                swap(nums, ++zero, i++);
//            }
//        }

    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

        int[] nums = {2, 0, 2, 1, 1, 0};

        (new Solution2()).sortColors(nums);
        for (int num : nums)
            System.out.println(num);
    }
}
