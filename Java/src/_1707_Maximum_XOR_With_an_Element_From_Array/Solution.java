package _1707_Maximum_XOR_With_an_Element_From_Array;

import java.util.Arrays;

/**
 * Date: 2021/5/23 11:10
 * 执行用时：270 ms, 在所有 Java 提交中击败了64.18%的用户
 * 内存消耗：114.9 MB, 在所有 Java 提交中击败了66.42%的用户
 */
public class Solution {

    static class Node {
        Node[] son = new Node[2];
        int min = Integer.MAX_VALUE;
    }

    Node root = new Node();

    private void insert(int val) {
        Node p = root;
        p.min = Math.min(p.min, val);
        for (int i = 29; i >= 0; i--) {
            int u = val >> i & 1;
            if (p.son[u] == null) p.son[u] = new Node();
            p = p.son[u];
            p.min = Math.min(p.min, val);
        }
    }

    private int query(int x, int m) {
        Node p = root;
        if (p.min > m) return -1;
        int res = 0;
        for (int i = 29; i >= 0; i--) {
            int u = x >> i & 1;
            if (p.son[1 ^ u] != null && p.son[1 ^ u].min <= m) {
                p = p.son[1 ^ u];
                res = res * 2 + 1 - u;
            } else {
                p = p.son[u];
                res = res * 2 + u;
            }
        }
        return res ^ x;
    }

    public int[] maximizeXor(int[] nums, int[][] queries) {

        for (int x : nums) insert(x);
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0], m = queries[i][1];
            res[i] = query(x, m);
        }
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {0, 1, 2, 3, 4};
        int[][] queries = { {3, 1}, {1, 3}, {5, 6}};
        System.out.println(Arrays.toString((new Solution()).maximizeXor(nums, queries)));  // [3, 3, 7]
    }
}
