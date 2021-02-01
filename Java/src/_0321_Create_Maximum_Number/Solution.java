package _0321_Create_Maximum_Number;

import _0000_study._common.Output;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Date: 2020/12/2 16:39
 * Content: 归并、单调栈
 * https://leetcode-cn.com/problems/remove-k-digits/solution/yi-zhao-chi-bian-li-kou-si-dao-ti-ma-ma-zai-ye-b-5/
 * <p>
 * 执行用时：22 ms, 在所有 Java 提交中击败了64.02%的用户
 * 内存消耗：39.1 MB, 在所有 Java 提交中击败了64.81%的用户
 */
public class Solution {

    // 类似于Leetcode 0402，此时保证nums.length >= k
    // 返回保留 len 位数据的最大值
    private int[] maxArray(int[] nums, int len) {

        int k = nums.length - len;  // 删除k位数据
        // 利用单调递减栈解决
        Deque<Integer> stack = new ArrayDeque<>();
        for (int num : nums) {
            while (k > 0 && !stack.isEmpty() && num > stack.peek()) {
                stack.pop();
                k--;
            }
            stack.push(num);
        }

        // 比如：nums:[4,3,2,1], len=2,则stack:[4,3,2,1] <- 栈顶，此时需要先出栈两个数据
        int[] res = new int[len];
        for (int i = 0; i < stack.size() - len; i++) stack.pop(); // 出栈多余的数据
        for (int i = res.length - 1; i >= 0; i--) res[i] = stack.pop();  // 得到结果
        return res;
    }

    // 将两个数据合成一个最大的数据
    private int[] merge(int[] nums1, int[] nums2) {

        int n1 = nums1.length, n2 = nums2.length;

        int[] res = new int[n1 + n2];

        int i = 0, j = 0;
        for (int k = 0; k < n1 + n2; k++) {
            if (i >= n1) res[k] = nums2[j++];
            else if (j >= n2) res[k] = nums1[i++];
            else if (compare(nums1, i, nums2, j)) {
                // 不能直接比较 nums1[i] > nums2[j]，在相等的情况下会导致错误，应该继续比较，需要替换为compare
                // 例子 int[] nums1 = {6, 7}; int[] nums2 = {6, 0, 4}; int k = 5;
                res[k] = nums1[i++];
            } else res[k] = nums2[j++];
        }
        return res;
    }

    // 从nums1[p1],nums2[p2] 开始比较数据的大小，如果相等的话，继续比较下一位
    // 如果 nums1[p1]比较大，但会true
    private boolean compare(int[] nums1, int p1, int[] nums2, int p2) {

        if (p1 >= nums1.length) return false;
        else if (p2 >= nums2.length) return true;
        else if (nums1[p1] > nums2[p2]) return true;
        else if (nums1[p1] < nums2[p2]) return false;
        else return compare(nums1, p1 + 1, nums2, p2 + 1);  // nums1[p1] == nums2[p2]
    }

    // 判断两个长度相等的数据的大小，如果 nums1 > nums2 返回true
    private boolean judge(int[] nums1, int[] nums2) {

        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] > nums2[i]) return true;
            else if (nums1[i] < nums2[i]) return false;
        }
        return false;  // 相等返回 false
    }

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {

        int n1 = nums1.length, n2 = nums2.length;

        int[] res = new int[k];
        for (int i = Math.max(0, k - n2); i <= Math.min(k, n1); i++) {
            int[] a = maxArray(nums1, i), b = maxArray(nums2, k - i);
            int[] c = merge(a, b);
            if (judge(c, res)) res = c;
        }
        return res;
    }

    public static void main(String[] args) {

//        // [9, 8, 6, 5, 3]
//        int[] nums1 = {3, 4, 6, 5};
//        int[] nums2 = {9, 1, 2, 5, 8, 3};
//        int k = 5;
//        int[] res = (new Solution()).maxNumber(nums1, nums2, k);

//        // [6, 7, 6, 0, 4]
//        int[] nums1 = {6, 7};
//        int[] nums2 = {6, 0, 4};
//        int k = 5;
//        int[] res = (new Solution()).maxNumber(nums1, nums2, k);

        // [9, 8, 9]
        int[] nums1 = {3, 9};
        int[] nums2 = {8, 9};
        int k = 3;
        int[] res = (new Solution()).maxNumber(nums1, nums2, k);
        Output.OutputBasicArray1D(res);
    }
}
/*
for (int i = Math.max(0, k - n2); i <= Math.min(k, n1); i++) {
// 0 <= i <= Math.min(k, n1), 0 <= k - i <= Math.min(k, n2)
// 所以  k - Math.min(k, n2) <= i  所以 k +  Math.max(-k, -n2) <= i
// 所以  Math.max(k-k, k-n2) <= i
 */