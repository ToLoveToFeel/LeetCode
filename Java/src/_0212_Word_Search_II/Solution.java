package _0212_Word_Search_II;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Date: 2021/1/31 11:15
 * Content:
 * 执行用时：166 ms, 在所有 Java 提交中击败了29.04%的用户
 * 内存消耗：39.2 MB, 在所有 Java 提交中击败了26.94%的用户
 */
public class Solution {

    static class Node {
        int id;
        Node[] son = new Node[26];

        Node() {
            id = -1;
            for (int i = 0; i < 26; i++) son[i] = null;
        }
    }

    Node root = new Node();
    HashSet<Integer> ids = new HashSet<>();  // 存储能被搜到的单词的id
    char[][] g;
    int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

    void insert(String s, int id) {
        Node p = root;
        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (p.son[u] == null) p.son[u] = new Node();
            p = p.son[u];
        }
        p.id = id;
    }

    public List<String> findWords(char[][] board, String[] words) {

        g = board;
        for (int i = 0; i < words.length; i++) insert(words[i], i);

        for (int i = 0; i < g.length; i++)
            for (int j = 0; j < g[0].length; j++) {
                int u = g[i][j] - 'a';
                if (root.son[u] != null)
                    dfs(i, j, root.son[u]);
            }

        List<String> res = new ArrayList<>();
        for (int id : ids) res.add(words[id]);
        return res;
    }

    // 从board[x][y]开始搜索以p为根的trie树中的单词
    void dfs(int x, int y, Node p) {
        if (p.id != -1) ids.add(p.id);
        char t = g[x][y];
        g[x][y] = '.';
        for (int i = 0; i < 4; i++) {
            int a = x + dx[i], b = y + dy[i];
            if (a >= 0 && a < g.length && b >= 0 && b < g[0].length && g[a][b] != '.') {
                int u = g[a][b] - 'a';
                if (p.son[u] != null) dfs(a, b, p.son[u]);
            }
        }
        g[x][y] = t;
    }

    public static void main(String[] args) {

        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] words = {"oath", "pea", "eat", "rain"};
        System.out.println((new Solution()).findWords(board, words));  // [oath, eat]
    }
}
