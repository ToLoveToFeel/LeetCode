package _0116_Populating_Next_Right_Pointers_in_Each_Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Date: 2020/10/15 11:26
 * Content:
 */
public class Solution2 {
    public Node connect(Node root) {
		if (root == null)
            return root;

        Node leftMost = root;
        while (leftMost.left != null) {  // 条件成立的话，说明完全二叉树还有下一层
            Node head = leftMost;  // 当前层的头结点

            while (head != null) {
                // 1: 左子树节点 指向 右子树节点
                head.left.next = head.right;
                // 2: 右子树节点 指向 head.next的左子树节点
                if (head.next != null)
                    head.right.next = head.next.left;

                head = head.next;
            }

            leftMost = leftMost.left;
        }

        return root;
    }
}
