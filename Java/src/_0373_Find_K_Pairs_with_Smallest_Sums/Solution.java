package _0373_Find_K_Pairs_with_Smallest_Sums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Date: 2021/5/12 22:16
 * 执行用时：5 ms, 在所有 Java 提交中击败了97.92%的用户
 * 内存消耗：39 MB, 在所有 Java 提交中击败了92.15%的用户
 */
public class Solution {

    public List<List<Integer>> kSmallestPairs(int[] a, int[] b, int k) {

        int n = a.length, m = b.length;
        if (n == 0 || m == 0) return new ArrayList<>();

        PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> { return o1[0] - o2[0]; });
        for (int i = 0; i < m; i++) heap.add(new int[]{a[0] + b[i], 0, i});
        List<List<Integer>> res = new ArrayList<>();
        while (k-- != 0 && !heap.isEmpty()) {
            int[] t = heap.remove();
            res.add(Arrays.asList(a[t[1]], b[t[2]]));
            if (t[1] + 1 < n)
                heap.add(new int[]{a[t[1] + 1] + b[t[2]], t[1] + 1, t[2]});
        }
        return res;
    }

    public static void main(String[] args) {

        int[] a = {1, 7, 11}, b = {2, 4, 6};
        System.out.println((new Solution()).kSmallestPairs(a, b, 3));  // [[1, 2], [1, 4], [1, 6]]
    }
}
