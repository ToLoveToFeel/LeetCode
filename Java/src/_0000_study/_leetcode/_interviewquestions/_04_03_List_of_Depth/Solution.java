package _0000_study._leetcode._interviewquestions._04_03_List_of_Depth;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Date: 2020/9/27 19:48
 * Content:
 * 层次遍历
 */
public class Solution {
    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null)
            return new ListNode[]{};

        List<ListNode> aux = new ArrayList<>();  // 辅助存储每层的链表的头结点，因为现在不知道数组的大小

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);
        int levelNum = 1;  // 当前层的节点数
        while (!queue.isEmpty()) {
            int newLevelNum = 0;
            ListNode dummyHead = new ListNode(-1);
            ListNode pre = dummyHead;
            for (int i = 0; i < levelNum; i++) {
                TreeNode node = queue.remove();
                pre.next = new ListNode(node.val);
                pre = pre.next;

                if (node.left != null) {
                    queue.add(node.left);
                    newLevelNum++;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    newLevelNum++;
                }
            }
            aux.add(dummyHead.next);
            levelNum = newLevelNum;
        }

        ListNode[] res = new ListNode[aux.size()];
        for (int i = 0; i < aux.size(); i++) {
            res[i] = aux.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
        int[] nums = new int[]{
                1,
                2, 3,
                4, 5, nu, 7,
                8
        };

        TreeNode root = (new MyTree(nums)).getRoot();
        ListNode[] res = (new Solution()).listOfDepth(root);
        for (ListNode head : res) {
            MyLinkedList.printLinkedList(head);
        }
    }
}
