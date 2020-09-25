package _0106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Date: 2020/9/25 10:54
 * Content:
 */
public class Solution {
    private int[] postder;  // 存储后续遍历序列
    private Map<Integer, Integer> map = new HashMap<>();  // 存储中序遍历对应数字的索引:(数字， 数字对应的索引)
    int rootIndex;  // 当前根节点的位置，在后续遍历中寻找根节点，因为后续遍历：左右根 --> 创建根，创建右子树，创建左子树

    // 根据 inorder[left...right] 构建二叉树
    private TreeNode buildTree(int left, int right) {
        if (left > right)
            return null;

        // 创建根
        int rootVal = postder[rootIndex];
        TreeNode root = new TreeNode(rootVal);

        // 获取根节点在中序遍历数组中的位置
        int index = map.get(rootVal);
        rootIndex--;  // 找到当前 root 右子树的根在后续遍历中的索引

        // 构建右子树
        root.right = buildTree(index + 1, right);
        // 构建左子树
        root.left = buildTree(left, index - 1);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postder = postorder;
        this.rootIndex = postorder.length - 1;  // 最开始根节点为后续遍历的最后一个元素
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(0, rootIndex);
    }

    public static void main(String[] args) {
        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
        int[] nums = new int[]{
                3,
                9, 20,
                nu, nu, 15, 7
        };

        MyTree myTree = new MyTree(nums);
        List<Integer> inorderList = myTree.inorderTraversal();
        List<Integer> postorderList = myTree.postorderTraversal();
        int[] inorder = new int[inorderList.size()];
        for (int i = 0; i < inorder.length; i++) {
            inorder[i] = inorderList.get(i);
        }
        int[] postorder = new int[postorderList.size()];
        for (int i = 0; i < postorder.length; i++) {
            postorder[i] = postorderList.get(i);
        }

        TreeNode root = (new Solution()).buildTree(inorder, postorder);
        System.out.println(MyTree.levelOrder(root));
    }
}
