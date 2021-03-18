package _0127_Word_Ladder;

import _0000_study._common.Build;

import java.util.*;

/**
 * Date: 2021/3/18 10:01
 * Content: BFS
 * 执行用时：283 ms, 在所有 Java 提交中击败了35.26%的用户
 * 内存消耗：42.1 MB, 在所有 Java 提交中击败了18.79%的用户
 */
class Solution3 {

    HashSet<String> S = new HashSet<>();
    HashMap<String, Integer> dist = new HashMap<>();
    Queue<String> q = new LinkedList<>();

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        S.addAll(wordList);
        q.add(beginWord);
        dist.put(beginWord, 0);
        while (!q.isEmpty()) {
            String t = q.remove();

            for (int i = 0; i < t.length(); i++)
                for (char j = 'a'; j <= 'z'; j++) {
                    String r = t.substring(0, i) + j + t.substring(i + 1);
                    if (S.contains(r) && !dist.containsKey(r)) {
                        dist.put(r, dist.get(t) + 1);
                        if (endWord.equals(r)) break;
                        q.add(r);
                    }
                }
        }
        return dist.getOrDefault(endWord, -1) + 1;
    }

    public static void main(String[] args) {

        List<String> wordList = Build.build(new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        System.out.println((new Solution3()).ladderLength("hit", "cog", wordList));

//        List<String> wordList = Build.build(new String[]{"a", "b", "c"});
//        System.out.println((new Solution3()).ladderLength("a", "c", wordList));
    }
}
