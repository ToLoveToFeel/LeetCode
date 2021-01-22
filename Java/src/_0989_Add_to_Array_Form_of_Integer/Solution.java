package _0989_Add_to_Array_Form_of_Integer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Date: 2021/1/22 9:45
 * Content:
 * 执行用时：5 ms, 在所有 Java 提交中击败了56.68%的用户
 * 内存消耗：39.9 MB, 在所有 Java 提交中击败了48.02%的用户
 */
public class Solution {

    public List<Integer> addToArrayForm(int[] A, int K) {

        List<Integer> res = new ArrayList<>();
        int t = 0, i = A.length - 1;
        while (i >= 0 || K != 0 || t != 0) {
            if (i >= 0) t += A[i--];
            if (K != 0) {
                t += K % 10;
                K /= 10;
            }
            res.add(t % 10);
            t /= 10;
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {

        // [1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        int[] A = {9, 9, 9, 9, 9, 9, 9, 9, 9, 9};
        int K = 1;
        System.out.println((new Solution()).addToArrayForm(A, K));
    }
}
