package _0000_study.classicalproblems.graph.wordladder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Date: 2020/11/5 9:00
 * Content: BFS
 * 执行用时：584 ms, 在所有 Java 提交中击败了31.98%的用户
 * 内存消耗：39.5 MB, 在所有 Java 提交中击败了73.34%的用户
 */
class Solution {
    private boolean isConnected(String word1, String word2) {  // 判断两个单词是否仅一个字母不同

        if (word1.length() != word2.length())
            return false;

        int count = 0;  // 不同字母的数量
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i))
                count++;
            if (count > 1)
                return false;
        }
        return count == 1;
    }

    // 构建无向无权图：graph[i] 存储的为节点 wordList[i] 连接到的单词的索引
    private List<List<Integer>> constructUndirectedGraph(String beginWord, List<String> wordList) {

        wordList.add(beginWord);
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < wordList.size(); i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < wordList.size(); i++) {
            for (int j = i + 1; j < wordList.size(); j++) {
                if (isConnected(wordList.get(i), wordList.get(j))) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }

        return graph;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size();
        boolean[] visited = new boolean[n + 1];

        // 构建图
        List<List<Integer>> graph = constructUndirectedGraph(beginWord, wordList);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);  // beginWord会放在wordList最后的位置用于建图
        visited[n] = true;
        int res = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();  // 当前层的节点个数
            for (int i = 0; i < size; i++) {  // 代表当前层
                int v = queue.remove();
                for (Integer w : graph.get(v)) {
                    if (!visited[w]) {
                        queue.add(w);
                        visited[w] = true;
                        if (wordList.get(w).equals(endWord))
                            return res + 1;
                    }
                }
            }
            res++;
        }

        return 0;
    }

    public static void main(String[] args) {
//        String beginWord = "hit";
//        String endWord = "cog";
//        List<String> wordList = new ArrayList<String>() {{
//            add("hot");
//            add("dot");
//            add("dog");
//            add("lot");
//            add("log");
//            add("cog");
//        }};
//        System.out.println((new Solution()).ladderLength(beginWord, endWord, wordList));
//        String beginWord = "hit";
//        String endWord = "cog";
//        List<String> wordList = new ArrayList<String>() {{
//            add("hot");
//            add("dot");
//            add("dog");
//            add("lot");
//            add("log");
//        }};
//        System.out.println((new Solution()).ladderLength(beginWord, endWord, wordList));
        String beginWord = "a";
        String endWord = "c";
        List<String> wordList = new ArrayList<String>() {{
            add("a");
            add("b");
            add("c");
        }};
        System.out.println((new Solution()).ladderLength(beginWord, endWord, wordList));
    }
}
