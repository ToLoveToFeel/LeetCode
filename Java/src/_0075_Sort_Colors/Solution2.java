package _0075_Sort_Colors;

public class Solution2 {
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    // 三路快排
    public void sortColors(int[] nums) {
        int zero = -1;          // nums[0...zero] == 0
        int two = nums.length;  // nums[two...n-1] == 2

        for (int i = 0; i < two; ){
            if (1 == nums[i])
                i++;
            else if (2 == nums[i])
                swap(nums, --two, i);
            else {
                if (0 != nums[i])
                    throw new IllegalArgumentException("Out of range [0..2]!");
                swap(nums, ++zero, i++);
            }
        }

    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,0};
        (new Solution2()).sortColors(nums);
        for (int i = 0; i < nums.length; i++)
            System.out.println(nums[i]);
    }
}
