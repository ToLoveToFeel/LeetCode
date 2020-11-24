package _0222_Count_Complete_Tree_Nodes;

/**
 * Date: 2020/11/24 9:09
 * Content: 充分利用完全二叉树的性质
 * https://leetcode-cn.com/problems/count-complete-tree-nodes/solution/c-san-chong-fang-fa-jie-jue-wan-quan-er-cha-shu-de/
 * 如果根节点的左子树深度等于右子树深度，则说明左子树为满二叉树
 * 如果根节点的左子树深度大于右子树深度，则说明右子树为满二叉树
 * <p>
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：40.8 MB, 在所有 Java 提交中击败了91.35%的用户
 */
public class Solution2 {

    // 统计树的深度
    private int countLevel(TreeNode node) {
        int depth = 0;
        while (node != null) {
            node = node.left;
            depth++;
        }
        return depth;
    }

    private int countNodes(TreeNode root, int leftDepth) {
        if (root == null)
            return 0;

        int rightDepth = countLevel(root.right);
        if (leftDepth == rightDepth) {
            // 左子树深度等于右子树深度, 则左子树是满二叉树
            // 满二叉树如果深度为 h(从0开始), 则节点个数为 2^h-1
            // 再加上根节点，一共 2^h-1+1=2^h 个节点
            return countNodes(root.right, rightDepth - 1) + (1 << leftDepth);
        } else {
            // 如果左子树深度大于右子树深度，则说明右子树为满二叉树
            return countNodes(root.left, leftDepth - 1) + (1 << rightDepth);
        }
    }

    public int countNodes(TreeNode root) {

        if (root == null)
            return 0;

        int leftDepth = countLevel(root.left);
        return countNodes(root, leftDepth);
    }

    public static void main(String[] args) {

        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
        int[] nums = new int[]{
                1,
                2, 3,
                4, 5, 6, nu
        };

        TreeNode root = (new MyTree(nums)).getRoot();

        System.out.println((new Solution2()).countNodes(root));
    }
}
