package _0413_Arithmetic_Slices;

/**
 * Date: 2021/5/31 19:31
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：36.4 MB, 在所有 Java 提交中击败了28.23%的用户
 */
public class Solution {

    public int numberOfArithmeticSlices(int[] A) {
        for (int i = A.length - 1; i > 0; i--) A[i] -= A[i - 1];
        int res = 0;
        for (int i = 1; i < A.length; i++) {
            int j = i;
            while (j < A.length && A[j] == A[i]) j++;
            int k = j - i;
            res += k * (k - 1) / 2;
            i = j - 1;
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).numberOfArithmeticSlices(new int[]{1, 2, 3, 4}));  // 3
    }
}
