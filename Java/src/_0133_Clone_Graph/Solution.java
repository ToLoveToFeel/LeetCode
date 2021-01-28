package _0133_Clone_Graph;

import java.util.HashMap;

/**
 * Date: 2021/1/28 11:10
 * Content:
 * 执行用时：34 ms, 在所有 Java 提交中击败了40.88%的用户
 * 内存消耗：38.7 MB, 在所有 Java 提交中击败了34.14%的用户
 */
public class Solution {

    HashMap<Node, Node> hash = new HashMap<>();  // 存储原图和复制出来的图的节点的对应关系

    private void dfs(Node node) {
        hash.put(node, new Node(node.val));
        for (Node ver : node.neighbors)
            if (!hash.containsKey(ver))
                dfs(ver);
    }

    public Node cloneGraph(Node node) {

        if (node == null) return null;

        // 复制所有点
        dfs(node);

        // 复制所有边
        for (Node s : hash.keySet()) {
            Node d = hash.get(s);
            for (Node ver : s.neighbors) {
                d.neighbors.add(hash.get(ver));
            }
        }

        return hash.get(node);
    }
}
