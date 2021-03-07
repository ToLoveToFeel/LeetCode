package _0503_Next_Greater_Element_II;

import _0000_study._common.Output;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by WXX on 2021/3/7 11:29
 * 执行用时：10 ms, 在所有 Java 提交中击败了67.18%的用户
 * 内存消耗：40.3 MB, 在所有 Java 提交中击败了41.04%的用户
 */
public class Solution {

    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        int[] arr = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) arr[i] = nums[i % n];

        Deque<Integer> stk = new ArrayDeque<>();
        int[] res = new int[n];
        for (int i = 2 * n - 1; i >= 0; i--) {
            int x = arr[i];
            while (!stk.isEmpty() && x >= stk.peek()) stk.pop();
            if (i < n) {
                if (stk.isEmpty()) res[i] = -1;
                else res[i] = stk.peek();
            }
            stk.push(x);
        }
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 1};
        Output.OutputBasicArray1D((new Solution()).nextGreaterElements(nums));
    }
}
