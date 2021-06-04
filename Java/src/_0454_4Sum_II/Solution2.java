package _0454_4Sum_II;

import java.util.HashMap;

/**
 * 执行用时：77 ms, 在所有 Java 提交中击败了63.93%的用户
 * 内存消耗：58.9 MB, 在所有 Java 提交中击败了34.18%的用户
 * <p>
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(n^2)
 */
public class Solution2 {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int c : C)
            for (int d : D)
                hash.put(c + d, hash.getOrDefault(c + d, 0) + 1);

        int res = 0;
        for (int a : A)
            for (int b : B)
                res += hash.getOrDefault(-(a + b), 0);
        return res;
    }

    public static void main(String[] args) {

        int[] A = {1, 2}, B = {-2, -1}, C = {-1, 2}, D = {0, 2};
        System.out.println((new Solution2()).fourSumCount(A, B, C, D));  // 2
    }
}
