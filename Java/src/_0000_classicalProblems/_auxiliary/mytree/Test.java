package _0000_classicalProblems._auxiliary.mytree;

/**
 * Date: 2020/9/4 17:41
 * Content:
 *         5
 *      /    \
 *     4      8
 *    /     /  \
 *   11    13   4
 *  /  \       / \
 * 7    2     5   1
 *
 */
public class Test {
    public static void main(String[] args) {
        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
        int[] nums = new int[]{
                5,
                4,8,
                11,nu,13,4,
                7,2,nu,nu,nu,nu,5,1
        };

//        TreeNode root = (new MyTree(nums)).getRoot();
        MyTree myTree = new MyTree(nums);
        System.out.println("myTree的层次遍历结果：" + myTree.levelOrder());
        System.out.println("myTree的前次遍历结果：" + myTree.preorderTraversal());
        System.out.println("myTree的中次遍历结果：" + myTree.inorderTraversal());
        System.out.println("myTree的后次遍历结果：" + myTree.postorderTraversal());
    }
}
