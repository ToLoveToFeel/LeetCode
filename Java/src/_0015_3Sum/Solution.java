package _0015_3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    // 使用查找表解决
    // 时间复杂度：O(n^2)
    // 空间复杂度：O(n)
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3)
            return res;

        HashMap<Integer, Integer> counter = new HashMap<>();  // 统计各元素出现次数，查找表
        for (int i = 0; i < nums.length; i++)
            if (!counter.containsKey(nums[i]))
                counter.put(nums[i], 1);
            else
                counter.put(nums[i], counter.get(nums[i]) + 1);

        if (counter.containsKey(0) && counter.get(0) >= 3)
            res.add(generateList(0, 0, 0));

        // 数组排序，默认升序排列
        Arrays.sort(nums);
        // 数组去重
        nums = unique(nums);

        for (int i = 0; i < nums.length; i++)
            for (int j = i+1; j < nums.length; j++){
                if (nums[i] * 2 + nums[j] == 0 && counter.get(nums[i]) >= 2)
                    res.add(generateList(nums[i], nums[i], nums[j]));
                if (nums[i] + nums[j] * 2 == 0 && counter.get(nums[j]) >= 2)
                    res.add(generateList(nums[i], nums[j], nums[j]));

                int c = 0 - nums[i] - nums[j];
                if (c > nums[j] && counter.containsKey(c))
                    res.add(generateList(nums[i], nums[j], c));
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

    // 对已经拍好序的数组去重，返回去重后的数组
    // LeetCode 0026号问题
    private int[] unique(int[] nums){
        if (nums.length == 0)
            return nums;

        int k = 1;  // [0...k)中的元素均为去重后的元素
        int removeValue = nums[0];
        for (int i = 1; i < nums.length; i++)
            if (nums[i] != removeValue){
                nums[k++] = nums[i];
                removeValue = nums[i];
            }

        int[] newNums = new int[k];
        for (int i = 0; i < newNums.length; i++)
            newNums[i] = nums[i];

        return newNums;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = (new Solution()).threeSum(nums);

        for (int i = 0; i < res.size(); i++){
            List item = res.get(i);
            System.out.println("[" + item.get(0) + " " + item.get(1) + " " +item.get(2) + "]");
        }
    }
}
