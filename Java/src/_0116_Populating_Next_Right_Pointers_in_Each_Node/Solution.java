package _0116_Populating_Next_Right_Pointers_in_Each_Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Date: 2020/10/15 11:26
 * Content:
 */
public class Solution {

    public Node connect(Node root) {

        if (root == null) return root;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int levelNum = 1;

        while (!q.isEmpty()) {
            int newLevelNum = 0;
            Node curNode = new Node();
            for (int i = 0; i < levelNum; i++) {
                Node node = q.remove();
                curNode.next = node;
                curNode = curNode.next;
                if (node.left != null) {
                    q.add(node.left);
                    newLevelNum++;
                }
                if (node.right != null) {
                    q.add(node.right);
                    newLevelNum++;
                }
            }
            curNode.next = null;
            levelNum = newLevelNum;
        }

        return root;
    }
}
