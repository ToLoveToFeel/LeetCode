package _0236_Lowest_Common_Ancestor_of_a_Binary_Tree;

/**
 * Date: 2020/9/27 9:43
 * Content:
 * 后续遍历
 */
public class Solution {
    // 在root中寻找p和q
    // 如果p和q都在root所在的二叉树中, 则返回LCA
    // 如果p和q只有一个在root所在的二叉树中, 则返回p或者q
    // 如果p和q均不在root所在的二叉树中, 则返回NULL
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        if (root == p || root == q)  // 这句话也可以，但是不方便调试
            return root;

//        if (root.val == p.val || root.val == q.val)
//            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null)  // 说明root的左子树包含p和q中的某一个，root的右子树也是如此
            return root;
        if (left != null)  // 左子树有返回值，右子树没有，说明左子树存在p和q中的某一个
            return left;
        if (right != null)  // 右子树有返回值，左子树没有，说明左右子树存在p和q中的某一个
            return right;
        return null;
    }

    public static void main(String[] args) {
        // 前提：p、q 为不同节点且均存在于给定的二叉树中。如果有一个不存在，则会得到不正确的结果，例如下面的树， p=3, q=2,会返回3
        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
        int[] nums = new int[]{
                3,
                5, 1,
//                6, 2, 0, 8,
//                nu, nu, 7, 4
        };

        TreeNode root = (new MyTree(nums)).getRoot();
        System.out.println(MyTree.levelOrder(root));
        System.out.println((new Solution()).lowestCommonAncestor(root, new TreeNode(3), new TreeNode(1)).val);
    }
}
