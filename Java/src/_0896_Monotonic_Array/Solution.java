package _0896_Monotonic_Array;

/**
 * Created by WXX on 2021/2/28 10:02
 * 执行用时：2 ms, 在所有 Java 提交中击败了40.70%的用户
 * 内存消耗：46.3 MB, 在所有 Java 提交中击败了86.68%的用户
 */
public class Solution {

    public boolean isMonotonic(int[] A) {

        boolean f1 = true, f2 = true;
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]) f1 = false;  // 不是单增
            if (A[i] > A[i - 1]) f2 = false;  // 不是单减
        }
        return f1 || f2;
    }

    public static void main(String[] args) {

        int[] A = {1, 2, 2, 3};
        System.out.println((new Solution()).isMonotonic(A));  // true
    }
}
