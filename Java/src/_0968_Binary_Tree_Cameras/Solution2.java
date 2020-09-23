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
        State 2: 这个节点安装了相机
     */
    private static final int NEED_COVER = 0;
    private static final int HAS_COVER = 1;
    private static final int NEED_CAMERA = 2;

    private int dfs(TreeNode node) {
        if (node == null)  // 空节点代表已经覆盖
            return HAS_COVER;

        int left = dfs(node.left);
        int right = dfs(node.right);
        if (left == NEED_COVER || right == NEED_COVER) {  // 左右节点至少有一个待覆盖
            res++;
            return NEED_CAMERA;
        }
        if (left == HAS_COVER && right == HAS_COVER)  // 左右节点都已经被覆盖
            return NEED_COVER;
        // left == HAS_COVER && right == NEED_CAMERA
        // left == NEED_CAMERA && right == HAS_COVER
        // left == NEED_CAMERA && right == NEED_CAMERA
        return HAS_COVER;  // left + right >= 3, 说明左右子节点至少有一个安装了相机
    }

    public int minCameraCover(TreeNode root) {
        if (dfs(root) == NEED_COVER)
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
