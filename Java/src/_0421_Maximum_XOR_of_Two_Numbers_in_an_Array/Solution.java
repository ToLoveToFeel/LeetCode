package _0421_Maximum_XOR_of_Two_Numbers_in_an_Array;

/**
 * Date: 2021/5/16 13:31
 * 执行用时：33 ms, 在所有 Java 提交中击败了90.68%的用户
 * 内存消耗：46.5 MB, 在所有 Java 提交中击败了52.17%的用户
 */
public class Solution {

    static class Node {
        Node[] son = new Node[2];
    }

    Node root = new Node();

    public int findMaximumXOR(int[] nums) {
        int res = 0;
        for (int x : nums) {
            res = Math.max(res, query(x));
            insert(x);
        }
        return res;
    }

    private void insert(int x) {
        Node p = root;
        for (int i = 30; i >= 0; i--) {
            int u = (x >> i) & 1;
            if (p.son[u] == null) p.son[u] = new Node();
            p = p.son[u];
        }
    }

    private int query(int x) {
        Node p = root;
        int res = 0;
        for (int i = 30; i >= 0; i--) {
            int u = (x >> i) & 1;
            if (p.son[u ^ 1] != null) {
                p = p.son[u ^ 1];
                res = res * 2 + 1 - u;
            } else {
                p = p.son[u];
                res = res * 2 + u;
            }
            // 数组模拟的话，刚开始没有元素时，p会一直是0，因此不会NPE
            // 这里不是数组模拟，因此刚开始trie中没有数据时，要让p一直指向root
            if (p == null) p = root;
        }
        return res ^ x;
    }

    public static void main(String[] args) {

        int[] nums = {3, 10, 5, 25, 2, 8};
        System.out.println((new Solution()).findMaximumXOR(nums));  // 28
    }
}
