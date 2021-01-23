package _0060_Permutation_Sequence;

import java.util.LinkedList;

/**
 * Date: 2020/9/5 10:07
 * Content:
 */
class Solution {

    private StringBuilder res;
    private int topK;
    private int count;
    private boolean[] used;

    // 向这个排列的末尾添加第 index+1 个元素，获得一个有 index+1 个元素的排列
    private void generatePermutation(int[] nums, int index) {
        if (index == nums.length) {
            count++;
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                res.append(nums[i]);
                used[i] = true;
                generatePermutation(nums, index + 1);
                if (count == topK) break;
                used[i] = false;
                res.deleteCharAt(res.length() - 1);
            }
        }
    }

    public String getPermutation(int n, int k) {

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = i + 1;

        res = new StringBuilder();
        topK = k;
        used = new boolean[n];  // 默认false

        generatePermutation(nums, 0);
        return res.toString();
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).getPermutation(3, 5));
        System.out.println((new Solution()).getPermutation(4, 9));
    }
}