package _0129_Sum_Root_to_Leaf_Numbers;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2020/9/4 21:11
 * Content:
 */
public class Solution {
    private List<String> searchNumbers(TreeNode node) {
        ArrayList<String> res = new ArrayList<>();

        if (node == null)
            return res;
        if (node.left == null && node.right==null){
            res.add(Integer.toString(node.val));
        }

        List<String> leftPaths = searchNumbers(node.left);
        for (String s : leftPaths) {
            StringBuilder sb = new StringBuilder(Integer.toString(node.val));
            sb.append(s);
            res.add(sb.toString());
        }

        List<String> rightPaths = searchNumbers(node.right);
        for (String s : rightPaths) {
            StringBuilder sb = new StringBuilder(Integer.toString(node.val));
            sb.append(s);
            res.add(sb.toString());
        }

        return res;
    }

    public int sumNumbers(TreeNode root) {
        ArrayList<String> list;

        if (root == null)
            return 0;

        list = (ArrayList<String>) searchNumbers(root);
        int sum = 0;
        for (String s : list) {
            sum += Integer.parseInt(s);
        }
        return sum;
    }

    public static void main(String[] args) {
        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
        int[] nums = new int[]{
                4,
                9,0,
                5,1
        };

        // 生成二叉树
        MyTree myTree = new MyTree(nums);
        TreeNode root = myTree.getRoot();
        // 计算
        System.out.println((new Solution()).sumNumbers(root));
    }
}
