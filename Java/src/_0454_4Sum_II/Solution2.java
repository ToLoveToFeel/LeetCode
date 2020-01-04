package _0454_4Sum_II;

import java.util.HashMap;

public class Solution2 {
    // 时间复杂度：O(n^2)
    // 空间复杂度：O(n^2)
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> record = new HashMap<>();

        for (int i = 0; i < C.length; i++)
            for (int j = 0; j < D.length; j++)
                if (!record.containsKey(C[i] + D[j]))
                    record.put(C[i] + D[j], 1);
                else
                    record.put(C[i] + D[j], record.get(C[i] + D[j]) + 1);

        int res = 0;
        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < B.length; j++)
                if (record.containsKey(0 - A[i] - B[j]))
                    res += record.get(0 - A[i] - B[j]);

        return res;
    }

    public static void main(String[] args) {
        int[] A = {1, 2};
        int[] B = {-2, -1};
        int[] C = {-1, 2};
        int[] D = {0, 2};

        System.out.println((new Solution2()).fourSumCount(A, B, C, D));
    }
}
