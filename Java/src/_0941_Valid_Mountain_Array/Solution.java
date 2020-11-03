package _0941_Valid_Mountain_Array;

/**
 * Date: 2020/11/3 8:50
 * Content:
 * 执行用时：2 ms, 在所有 Java 提交中击败了41.65%的用户
 * 内存消耗：39.2 MB, 在所有 Java 提交中击败了96.46%的用户
 */
public class Solution {
    public boolean validMountainArray(int[] A) {
        if (A.length <= 2)
            return false;

        // [0...p)上升，(p...n-1]下降
        int p = 0;
        for (int i = 0; i + 1 < A.length; i++) {  // 寻找上升的峰
            if (A[i] > A[i + 1]) {
                p = i;
                break;
            } else if (A[i] == A[i + 1]) {
                return false;
            }
        }
        for (int i = p; i + 1 < A.length; i++) { // 寻找下降的峰
            if (A[i] <= A[i + 1])
                return false;
        }

        return (p != 0) && (p != A.length - 1);
    }

    public static void main(String[] args) {
//        int[] A = {1, 2};  // false
//        int[] A = {3, 5, 5};  // false
        int[] A = {0, 3, 2, 1};  // false
        System.out.println((new Solution()).validMountainArray(A));
    }
}
