package _0968_Binary_Tree_Cameras;

/**
 * Date: 2020/9/22 8:55
 * Content:
 */
public class Solution2 {
    int res = 0;

    /*
    对于某个节点，有三种状态：
        State 0: 这个节点待覆盖
        State 1: 这个节点已经覆盖
        State 2: 给这个节点安装相机
     */
    private int dfs(TreeNode node) {
        if (node == null)  // 空节点代表已经覆盖
            return 1;

        int left = dfs(node.left);
        int right = dfs(node.right);
        if (left == 0 || right == 0) {  // 左右节点至少有一个待覆盖
            res++;
            return 2;
        }
        if (left == 1 && right == 1)  // 左右节点都已经被覆盖
            return 0;
        return 1;  // left + right >= 3, 说明左右子节点至少有一个安装了相机
    }

    public int minCameraCover(TreeNode root) {
        if (dfs(root) == 0)
            res++;
        return res;
    }

    public static void main(String[] args) {
        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
        int[] nums = new int[]{
                1,
                1, nu,
                1, 1, nu, nu
        };

        TreeNode root = (new MyTree(nums)).getRoot();

        System.out.println((new Solution2()).minCameraCover(root));
    }
}
