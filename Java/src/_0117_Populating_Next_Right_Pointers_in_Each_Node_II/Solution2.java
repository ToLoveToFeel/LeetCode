package _0117_Populating_Next_Right_Pointers_in_Each_Node_II;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Date: 2020/9/28 8:36
 * Content:
 * 层次遍历
 */
public class Solution2 {
    public Node connect(Node root) {
        if (root == null)
            return root;

        Node cur = root;
        while (cur != null) {
            Node dummyHead = new Node(0);
            Node pre = dummyHead;
            // 遍历当前层的节点
            while (cur != null) {
                if (cur.left != null) {
                    pre.next = cur.left;
                    pre = pre.next;
                }
                if (cur.right != null) {
                    pre.next = cur.right;
                    pre = pre.next;
                }
                cur = cur.next;
            }
            // 下一层的最左节点，相当于 116 中的 leftMost
            cur = dummyHead.next;
        }

        return root;
    }
}
