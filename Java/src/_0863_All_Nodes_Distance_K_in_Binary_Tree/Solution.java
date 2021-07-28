package _0863_All_Nodes_Distance_K_in_Binary_Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Date: 2021/7/28 9:27
 * Content:
 */
public class Solution {

    HashMap<TreeNode, List<TreeNode>> g = new HashMap<>();
    List<Integer> ans = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        dfs1(root);
        dfs2(target, null, k);
        return ans;
    }

    private void dfs1(TreeNode root) {

        if (!g.containsKey(root)) g.put(root, new ArrayList<>());

        if (root.left != null) {
            if (!g.containsKey(root.left)) g.put(root.left, new ArrayList<>());
            g.get(root).add(root.left);
            g.get(root.left).add(root);
            dfs1(root.left);
        }
        if (root.right != null) {
            if (!g.containsKey(root.right)) g.put(root.right, new ArrayList<>());
            g.get(root).add(root.right);
            g.get(root.right).add(root);
            dfs1(root.right);
        }
    }

    private void dfs2(TreeNode root, TreeNode father, int k) {
        if (k == 0) ans.add(root.val);
        else {
            for (TreeNode son : g.get(root))
                if (son != null && son != father)
                    dfs2(son, root, k - 1);
        }
    }

    public static void main(String[] args) {

        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
        int[] nums = {
                3,
                5, 1,
                6, 2, 0, 8,
                nu, nu, 7, 4
        };
        TreeNode root = (new MyTree(nums)).getRoot();
        TreeNode target = root.left;
        System.out.println((new Solution()).distanceK(root, target, 2));  // [1, 7, 4]
    }
}
