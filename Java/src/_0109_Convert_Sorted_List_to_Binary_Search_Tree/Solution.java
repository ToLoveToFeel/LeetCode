package _0109_Convert_Sorted_List_to_Binary_Search_Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2020/10/2 9:39
 * Content:
 */
public class Solution {
    private TreeNode sortedListToBST(List<Integer> list, int l, int r) {
        if (l > r) return null;

        int mid = (r - l) / 2 + l;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = sortedListToBST(list, l, mid - 1);
        root.right = sortedListToBST(list, mid + 1, r);
        return root;
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
