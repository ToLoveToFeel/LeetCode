package _0015_3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 使用双索引技术解决
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 */
public class Solution2 {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) return res;

        // 数组排序，默认升序排列
        Arrays.sort(nums);

        int index = 0;
        while (index < nums.length) {
            if (nums[index] > 0)
                break;

            int leftIndex = index + 1;
            int rightIndex = nums.length - 1;
            while (leftIndex < rightIndex) {
                if (nums[leftIndex] + nums[rightIndex] == -nums[index]) {
                    res.add(generateList(nums[leftIndex], nums[rightIndex], nums[index]));

                    // 寻找其他符合条件的数据对
                    leftIndex = next_num_index(nums, leftIndex);
                    rightIndex = pre_num_index(nums, rightIndex);
                } else if (nums[leftIndex] + nums[rightIndex] < -nums[index])
                    leftIndex = next_num_index(nums, leftIndex);
                else  // nums[bindex] + nums[cindex] > -nums[index]
                    rightIndex = pre_num_index(nums, rightIndex);
            }

            index = next_num_index(nums, index);
        }

        return res;
    }

    private List<Integer> generateList(int a, int b, int c) {

        List<Integer> item = new ArrayList<>();
        item.add(a);
        item.add(b);
        item.add(c);

        return item;
    }

    // 返回nums[index+1...n)中第一个不等于nums[index]的数据的下标
    private int next_num_index(int[] nums, int index) {
        for (int i = index + 1; i < nums.length; i++)
            if (nums[i] != nums[index])
                return i;
        return nums.length;
    }

    // 返回nums[0...index-1]中第一个不等于nums[index]的数据的下标
    private int pre_num_index(int[] nums, int index) {
        for (int i = index - 1; i >= 0; i--)
            if (nums[i] != nums[index])
                return i;
        return -1;
    }

    public static void main(String[] args) {

        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println((new Solution2()).threeSum(nums));
    }
}
