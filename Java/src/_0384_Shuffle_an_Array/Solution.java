package _0384_Shuffle_an_Array;

import java.util.Arrays;
import java.util.Random;

/**
 * Date: 2021/5/29 21:31
 * 执行用时：97 ms, 在所有 Java 提交中击败了72.89%的用户
 * 内存消耗：46.5 MB, 在所有 Java 提交中击败了87.51%的用户
 */
public class Solution {

    int[] a;
    Random random = new Random();

    public Solution(int[] nums) {
        a = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return a;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int n = a.length;
        int[] b = new int[n];
        System.arraycopy(a, 0, b, 0, n);
        for (int i = 0; i < n; i++) {
            int j = i + random.nextInt(n - i);
            int t = b[i]; b[i] = b[j]; b[j] = t;
        }
        return b;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        System.out.println(Arrays.toString((new Solution(nums)).shuffle()));
        System.out.println(Arrays.toString((new Solution(nums)).shuffle()));
        System.out.println(Arrays.toString((new Solution(nums)).shuffle()));
    }
}
