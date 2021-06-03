package _0449_Serialize_and_Deserialize_BST;

import java.util.LinkedList;

/**
 * Date: 2021/6/3 20:06
 * 执行用时：16 ms, 在所有 Java 提交中击败了42.72%的用户
 * 内存消耗：40 MB, 在所有 Java 提交中击败了14.81%的用户
 */
public class Solution {

    static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            dfs_s(root, sb);
            return sb.toString();
        }

        private void dfs_s(TreeNode root, StringBuilder sb) {
            if (root == null) return;
            sb.append(root.val).append(" ");
            dfs_s(root.left, sb); dfs_s(root.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String str) {
            String[] t = str.split("\\s+");
            LinkedList<Integer> data = new LinkedList<>();
            for (String s : t)
                if (!s.equals(""))
                    data.add(Integer.parseInt(s));
            return dfs_d(data, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        private TreeNode dfs_d(LinkedList<Integer> data, int minv, int maxv) {
            if (data.isEmpty() || data.getFirst() < minv || data.getFirst() > maxv) return null;
            TreeNode root = new TreeNode(data.removeFirst());
            root.left = dfs_d(data, minv, root.val - 1);
            root.right = dfs_d(data, root.val + 1, maxv);
            return root;
        }
    }

    public static void main(String[] args) {

        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
        int[] nums = new int[]{
                2,
                1, 3
        };
        TreeNode root = (new MyTree(nums)).getRoot();

        Codec t = new Codec();
        String s = t.serialize(root);  // 2 1 3
        System.out.println(s);
        System.out.println(MyTree.levelOrder(t.deserialize(s)));  // [[2], [1, 3]]
    }
}
