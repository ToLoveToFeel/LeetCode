package _0015_3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    // 使用双索引技术解决
    // 时间复杂度：O(n^2)
    // 空间复杂度：O(n)
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3)
            return res;

        Arrays.sort(nums);
        int index = 0;
        while (index < nums.length){
            if (nums[index] > 0)
                break;;

            int leftIndex = index + 1;
            int rightIndex = nums.length - 1;
            while (leftIndex < rightIndex){
                if (nums[leftIndex] + nums[rightIndex] == -nums[index]){
                    res.add(generateList(nums[leftIndex], nums[rightIndex], nums[index]));

                    // continue to look for other pairs
                    leftIndex = next_num_index(nums, leftIndex);
                    rightIndex = pre_num_index(nums, rightIndex);
                }
                else if (nums[leftIndex] + nums[rightIndex] < -nums[index])
                    leftIndex = next_num_index(nums, leftIndex);
                else  // nums[bindex] + nums[cindex] > -nums[index]
                    rightIndex = pre_num_index(nums, rightIndex);
            }
            index = next_num_index(nums, index);
        }

        return res;
    }

    private List<Integer> generateList(int a, int b, int c){
        List<Integer> item = new ArrayList<>();
        item.add(a);
        item.add(b);
        item.add(c);

        return item;
    }

    private int next_num_index(int[] nums, int index){
        for (int i = index + 1; i < nums.length; i++)
            if (nums[i] != nums[index])
                return i;
        return nums.length;
    }

    private int pre_num_index(int[] nums, int index){
        for (int i = index - 1; i >= 0; i--)
            if (nums[i] != nums[index])
                return i;
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = (new Solution2()).threeSum(nums);

        for (int i = 0; i < res.size(); i++){
            List item = res.get(i);
            System.out.println("[" + item.get(0) + " " + item.get(1) + " " +item.get(2) + "]");
        }
    }
}
