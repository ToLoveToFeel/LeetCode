package _0105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Date: 2020/9/25 11:25
 * Content:
 */
public class Solution {

    private int[] preorder;
    private Map<Integer, Integer> map = new HashMap<>();  // 存储中序遍历对应数字的索引:(数字， 数字对应的下标)
    int rootIndex;  // 当前根节点的位置，在前序遍历中寻找根节点，因为前序遍历：根左右 --> 创建根，创建左子树，创建右子树

	// 根据 inorder[left...right] 构建二叉树
    private TreeNode buildTree(int left, int right) {

        if (left > right) return null;

        // 构建根节点
        int rootVal = preorder[rootIndex];
        TreeNode root = new TreeNode(rootVal);

        // 获取根节点在中序遍历数组中的位置
        int index = map.get(rootVal);
        rootIndex++;  // 找到当前 root 右子树的根在后续遍历中的索引
        
        // 构建左子树
        root.left = buildTree(left, index - 1);
		// 创建右子树
        root.right = buildTree(index + 1, right);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        this.preorder = preorder;
        this.rootIndex = 0;  // 最开始根节点为前续遍历的第一个元素

        for (int i = 0; i < preorder.length; i++) map.put(inorder[i], i);

        return buildTree(rootIndex, inorder.length - 1);
    }

    public static void main(String[] args) {
        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
        int[] nums = new int[]{
                3,
                9, 20,
                nu, nu, 15, 7
        };

        MyTree myTree = new MyTree(nums);
        List<Integer> preorderList = myTree.preorderTraversal();
        List<Integer> inorderList = myTree.inorderTraversal();
        int[] preorder = new int[preorderList.size()];
        for (int i = 0; i < preorder.length; i++) {
            preorder[i] = preorderList.get(i);
        }
        int[] inorder = new int[inorderList.size()];
        for (int i = 0; i < inorder.length; i++) {
            inorder[i] = inorderList.get(i);
        }

        TreeNode root = (new Solution()).buildTree(preorder, inorder);
        System.out.println(MyTree.levelOrder(root));
    }
}
