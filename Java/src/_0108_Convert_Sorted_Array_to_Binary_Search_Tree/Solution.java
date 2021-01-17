package _0108_Convert_Sorted_Array_to_Binary_Search_Tree;

/**
 * Date: 2020/10/1 11:00
 * Content:
 */
public class Solution {

    // 根据数组 nums[l...r] 创建 BST, 并返回 BST 的根
    private TreeNode sortedArrayToBST(int[] nums, int l, int r) {

        if (l > r) return null;

        int mid = (r - l) / 2 + l;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, l, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, r);

        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {

        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {

//        int[] nums = {};
//        int[] nums = {-10};
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode root = (new Solution()).sortedArrayToBST(nums);
        System.out.println(MyTree.levelOrder(root));
    }
}
