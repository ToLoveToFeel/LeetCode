package _0179_Largest_Number;

import java.util.Arrays;

/**
 * Date: 2021/4/12 10:51
 * 执行用时：15 ms, 在所有 Java 提交中击败了9.97%的用户
 * 内存消耗：39.2 MB, 在所有 Java 提交中击败了5.02%的用户
 */
public class Solution {

    public String largestNumber(int[] nums) {
        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) arr[i] = nums[i];
        Arrays.sort(arr, (x, y) -> {
            String a = x + "", b = y + "";
            return (b + a).compareTo(a + b);
        });
        StringBuilder sb = new StringBuilder();
        for (Integer x : arr) sb.append(x);
        int k = 0;
        while (k + 1 < arr.length && sb.charAt(k) == '0') k++;
        return sb.substring(k);
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).largestNumber(new int[]{10, 2}));
    }
}
