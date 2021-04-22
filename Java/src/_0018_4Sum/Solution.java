package _0018_4Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 使用双索引技术解决
 * 时间复杂度：O(n*logn + n^3)
 * 空间复杂度：O(1)
 */
public class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        if (n <= 3) return res;

        // 数组排序，默认升序排列
        Arrays.sort(nums);

        for (int i = 0; i <= n - 4; i = next_num_index(nums, i))
            for (int j = i + 1; j <= n - 3; j = next_num_index(nums, j)) {
                // 待查找的目标t
                int t = target - nums[i] - nums[j];
                if (nums[j + 1] + nums[j + 2] > t || nums[n - 1] + nums[n - 2] < t) continue;

                int p1 = j + 1, p2 = n - 1;
                while (p1 < p2) {
                    if (nums[p1] + nums[p2] == t) {
                        res.add(generateList(nums[i], nums[j], nums[p1], nums[p2]));
                        p1 = next_num_index(nums, p1);
                        p2 = pre_num_index(nums, p2);
                    } else if (nums[p1] + nums[p2] < t)
                        p1 = next_num_index(nums, p1);
                    else
                        p2 = pre_num_index(nums, p2);
                }
            }
        return res;
    }

    private List<Integer> generateList(int a, int b, int c, int d) {
        List<Integer> item = new ArrayList<>();
        item.add(a);
        item.add(b);
        item.add(c);
        item.add(d);
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

        int[] nums = {1, 0, -1, 0, -2, 2};
        System.out.println((new Solution()).fourSum(nums, 0));
    }
}
