package _0173_Binary_Search_Tree_Iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WXX on 2021/3/28 10:24
 */
public class Solution {

    static class BSTIterator {

        private List<Integer> nums;
        private int k;

        private void dfs(TreeNode root) {
            if (root != null) {
                dfs(root.left);
                nums.add(root.val);
                dfs(root.right);
            }
        }

        public BSTIterator(TreeNode root) {
            nums = new ArrayList<>();
            dfs(root);
            k = 0;
        }

        public int next() {
            return nums.get(k++);
        }

        public boolean hasNext() {
            return k < nums.size();
        }
    }

    public static void main(String[] args) {

        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
        int[] nums = new int[]{
                7,
                3, 15,
                nu, nu, 9, 20
        };
        TreeNode root = (new MyTree(nums)).getRoot();

        BSTIterator t = new BSTIterator(root);
        System.out.println(t.next());  // 3
        System.out.println(t.next());  // 7
        System.out.println(t.hasNext());  // true
        System.out.println(t.next());  // 9
        System.out.println(t.hasNext());  // true
        System.out.println(t.next());  // 15
        System.out.println(t.hasNext());  // true
        System.out.println(t.next());  // 20
        System.out.println(t.hasNext());  // false
    }
}
