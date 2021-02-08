package _0978_Longest_Turbulent_Subarray;

/**
 * Date: 2021/2/8 16:15
 * Content:
 * 执行用时：6 ms, 在所有 Java 提交中击败了87.95%的用户
 * 内存消耗：42 MB, 在所有 Java 提交中击败了43.94%的用户
 */
public class Solution {

    public int maxTurbulenceSize(int[] arr) {

        int res = 1;
        int f0 = 1, f1 = 1;  // f0记录arr[i-1]>arr[i]的数组的长度
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                f0 = f1 + 1;
                f1 = 1;
            } else if (arr[i - 1] < arr[i]) {
                f1 = f0 + 1;
                f0 = 1;
            } else {
                f0 = 1;
                f1 = 1;
            }
            res = Math.max(res, Math.max(f0, f1));
        }
        return res;
    }

    public static void main(String[] args) {

        int[] arr = {9, 4, 2, 10, 7, 8, 8, 1, 9};
        System.out.println((new Solution()).maxTurbulenceSize(arr));
    }
}
