package _0617_Merge_Two_Binary_Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Date: 2020/9/4 15:55
 * Content:
 */
public class MyTree {
    private TreeNode root;  // 二叉树的根
    private int size;  // 二叉树节点个数

    public MyTree() {
        root = null;
        size = 0;
    }

    // 根据层次遍历创建
    public MyTree(int[] nums) {
        this();
        if (nums.length == 0 || nums[0] == Integer.MIN_VALUE)
            return;
        root = new TreeNode(nums[0]);
        size++;
        createByLevelOrder(root, nums, 0);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public TreeNode getRoot() {
        return root;
    }

    // 创建二叉树
    public void createByLevelOrder(int[] nums) {
        if (nums.length == 0 || nums[0] == Integer.MIN_VALUE)
            return;

        root = new TreeNode(nums[0]);
        size++;
        createByLevelOrder(root, nums, 0);
    }

    // 创建以node为根节点的二叉树，index代表当前节点node.val的值为nums[index]
    // 只有nums[index] != Integer.MIN_VALUE 才能进入该函数
    private void createByLevelOrder(TreeNode node, int[] nums, int index) {
        // Integer.MIN_VALUE代表该节点为null
        int n = nums.length;
        if (index >= n)
            return;

        // 0 1 2
        int leftIndex = 2 * index + 1;  // nums[index]对应二叉树节点的左孩子下标为 2 * index + 1
        if (leftIndex <= n - 1) {  // 说明 num[leftIndex] 存在
            if (nums[leftIndex] != Integer.MIN_VALUE) {
                node.left = new TreeNode(nums[leftIndex]);
                size++;
                createByLevelOrder(node.left, nums, leftIndex);
            }
            int rightIndex = leftIndex + 1;  // nums[index]对应二叉树节点的左孩子下标为 2 * index + 2
            if (rightIndex <= n - 1) {  // 只有 num[leftIndex] 存在，考察rightIndex才有意义
                if (nums[rightIndex] != Integer.MIN_VALUE) {
                    node.right = new TreeNode(nums[rightIndex]);
                    size++;
                    createByLevelOrder(node.right, nums, rightIndex);
                }
            }
        }
    }

    // 层次遍历
    public static ArrayList<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (null == root)
            return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int levelNum = 1;  // 当前层的节点数

        while (!queue.isEmpty()) {
            int newLevelNum = 0;
            ArrayList<Integer> level = new ArrayList<>();
            for (int i = 0; i < levelNum; i++) {  // 遍历当前层的所有节点
                TreeNode node = queue.remove();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                    newLevelNum++;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    newLevelNum++;
                }
            }
            res.add(level);
            levelNum = newLevelNum;
        }
        System.out.println(res);
        return res;
    }

    // 前中后序遍历时空复杂度都一样
    // 时间复杂度：O(n)，n为节点数目
    // 空间复杂度：O(h)，h为二叉树高度
    // 前序遍历：递归算法
    public ArrayList<Integer> preorderTraversal() {
        ArrayList<Integer> res = new ArrayList<>();
        preorderTraversal(root, res);
        return res;
    }
    private void preorderTraversal(TreeNode node, List<Integer> list){
        if (null != node){
            list.add(node.val);
            preorderTraversal(node.left, list);
            preorderTraversal(node.right, list);
        }
    }

    // 中序遍历：递归算法
    public ArrayList<Integer> inorderTraversal() {
        ArrayList<Integer> res = new ArrayList<>();
        inorderTraversal(root, res);
        return res;
    }
    private void inorderTraversal(TreeNode node, List<Integer> list){
        if (null != node){
            inorderTraversal(node.left, list);
            list.add(node.val);
            inorderTraversal(node.right, list);
        }
    }

    // 后序遍历：递归算法
    public ArrayList<Integer> postorderTraversal() {
        ArrayList<Integer> res = new ArrayList<>();
        postorderTraversal(root, res);
        return res;
    }
    private void postorderTraversal(TreeNode node, List<Integer> list){
        if (null != node){
            postorderTraversal(node.left, list);
            postorderTraversal(node.right, list);
            list.add(node.val);
        }
    }
}
