package _0000_study.classicalproblems.findmaxmin;

/**
 * Date: 2020/11/11 16:18
 * Content:
 */
public class FindMaxMin {

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public int[] findMaxMin(int[] nums) {

        int n = nums.length;

        assert n >= 1;  // 数组中至少要有一个元素
        if (n == 1)
            return new int[]{nums[0], nums[0]};

        // 第一步：索引为偶数的元素和索引为奇数的元素比较，较大者放在偶数索引位置上
        // 注意：这一步已经改变输入数组结构了，也可以不更改，那就需要额外的空间了
        for (int i = 1; i < n; i += 2) {
            if (nums[i - 1] < nums[i]) {
                swap(nums, i - 1, i);
            }
        }

        // 第二步：在偶数位置寻找最大值，在奇数位置寻找最小值
        int max = nums[0];
        int min = nums[1];
        for (int i = 2; i < n; i += 2)
            max = Math.max(max, nums[i]);
        for (int i = 1; i < n; i += 2)
            min = Math.min(min, nums[i]);

        // 第三步：处理数组长度为奇数的情况，需要和最后一个元素比较
        if ((n & 1) == 1) {
            max = Math.max(max, nums[n - 1]);
            min = Math.min(min, nums[n - 1]);
        }

        return new int[]{max, min};
    }

    public static void main(String[] args) {

//        int[] nums = {1};  // Max : 1 , Min : 1
//        int[] nums = {3, 2, 6, 4};  // Max : 6 , Min : 2
        int[] nums = {3, 2, 6, 4, 9};  // Max : 9 , Min : 2
        int[] res = (new FindMaxMin()).findMaxMin(nums);

        System.out.print("Max : " + res[0] + " , Min : " + res[1]);
    }
}
