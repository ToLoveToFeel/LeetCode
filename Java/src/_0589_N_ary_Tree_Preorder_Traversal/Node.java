package _0589_N_ary_Tree_Preorder_Traversal;

import java.util.List;

/**
 * Date: 2020/11/2 8:42
 * Content:
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
