package _0297_Serialize_and_Deserialize_Binary_Tree;

/**
 * Date: 2021/5/5 17:24
 */
public class Solution {

    static class Codec {

        String path = "";
        int u = 0;  // deserialize使用，表示处理到data[u]

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            dfs_s(root);
            return path;
        }

        private void dfs_s(TreeNode root) {
            if (root == null) path += "#,";
            else {
                path += root.val + ",";
                dfs_s(root.left);
                dfs_s(root.right);
            }
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            u = 0;
            return dfs_d(data);
        }

        private TreeNode dfs_d(String s) {
            if (s.charAt(u) == '#') {
                u += 2;
                return null;
            }
            int k = u;
            while (s.charAt(u) != ',') u++;
            TreeNode root = new TreeNode(Integer.parseInt(s.substring(k, u)));
            u++;
            root.left = dfs_d(s);
            root.right = dfs_d(s);
            return root;
        }
    }

    public static void main(String[] args) {

        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
        int[] nums = new int[]{
                1,
                2, 3,
                nu, nu, 4, 5
        };
        TreeNode root = (new MyTree(nums)).getRoot();

        Codec t = new Codec();
        String s = t.serialize(root);
        System.out.println(s);
        System.out.println(MyTree.levelOrder(t.deserialize(s)));
    }
}
