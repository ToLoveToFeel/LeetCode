package _0109_Convert_Sorted_List_to_Binary_Search_Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2020/10/2 9:39
 * Content:
 */
public class Solution {
    private TreeNode sortedListToBST(List<Integer> list, int left, int right) {
        if (left > right)
            return null;

        int mid = (right - left) / 2 + left;

        TreeNode node = new TreeNode(list.get(mid));
        node.left = sortedListToBST(list, left, mid - 1);
        node.right = sortedListToBST(list, mid + 1, right);

        return node;
    }

    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode curNode = head;
        while (curNode != null) {
            list.add(curNode.val);
            curNode = curNode.next;
        }

        return sortedListToBST(list, 0, list.size() - 1);
    }

    public static void main(String[] args) {
        ListNode head = (new MyLinkedList(new int[]{-10, -3, 0, 5, 9})).getHead();
        TreeNode root = (new Solution()).sortedListToBST(head);
        System.out.println(MyTree.levelOrder(root));
    }
}
