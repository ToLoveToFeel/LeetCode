package _0396_Rotate_Function;

/**
 * Date: 2021/2/22 14:57
 * Content:
 * 设 S = A[0]+A[1]+A[2]+......+A[n-2]+A[n-1]
 * A[0]     A[1]    A[2]    ......      A[n-2]    A[n-1]
 *  0        1       2                    n-2       n-1     F[0]
 *  1        2       3                    n-1       n-n     F[1]     F[1]-F[0]=S-n*A[n-1]
 *  2        3       4                    n-n        1      F[2]     F[2]-F[1]=S-n*A[n-2]
 *  ......
 * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：38.9 MB, 在所有 Java 提交中击败了9.07%的用户
 */
public class Solution {

    public int maxRotateFunction(int[] A) {

        long sum = 0, cur = 0;
        int n = A.length;
        for (int x : A) sum += x;
        for (int i = 0; i < n; i++) cur += i * A[i];
        long res = cur;
        for (int i = n - 1; i >= 0; i--) {
            cur += sum - (long) n * A[i];
            res = Math.max(res, cur);
        }
        return (int) res;
    }

    public static void main(String[] args) {

        int[] A = {4, 3, 2, 6};
        System.out.println((new Solution()).maxRotateFunction(A));
    }
}
