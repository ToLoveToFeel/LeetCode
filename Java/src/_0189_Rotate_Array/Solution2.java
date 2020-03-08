package _0189_Rotate_Array;

public class Solution2 {
    /*
        我们可以用一个额外的数组来将每个元素放到正确的位置上，也就是原本数组里下标为 i 的我们把它
        放到 (i + k)% 数组长度的位置。然后把新的数组拷贝到原数组中。
     */
    // 使用额外的数组
    // 时间复杂度：O(n)
    // 时间复杂度：O(n)
    public void rotate(int[] nums, int k) {

        if (k % nums.length == 0)
            return;

        int[] newNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            newNums[(i+k) % nums.length] = nums[i];
        for (int i = 0; i < nums.length; i++)
            nums[i] = newNums[i];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        (new Solution2()).rotate(nums, k);
        for (int i = 0; i < nums.length; i++)
            System.out.print(nums[i] + " ");
    }
}
