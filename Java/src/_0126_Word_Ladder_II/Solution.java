package _0126_Word_Ladder_II;

import _0000_study._common.Build;

import java.util.*;

/**
 * Created by WXX on 2021/3/18 9:29
 * 执行用时：254 ms, 在所有 Java 提交中击败了58.92%的用户
 * 内存消耗：42.3 MB, 在所有 Java 提交中击败了78.18%的用户
 */
public class Solution {

    HashSet<String> S = new HashSet<>();
    HashMap<String, Integer> dist = new HashMap<>();
    Queue<String> q = new LinkedList<>();
    List<List<String>> ans = new ArrayList<>();
    ArrayList<String> path = new ArrayList<>();
    String beginWord;

    public List<List<String>> findLadders(String _beginWord, String endWord, List<String> wordList) {

        S.addAll(wordList);
        beginWord = _beginWord;
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

        if (!dist.containsKey(endWord)) return ans;
        path.add(endWord);
        dfs(endWord);
        return ans;
    }

    private void dfs(String t) {
        if (beginWord.equals(t)) {
            Collections.reverse(path);
            ans.add((List<String>) path.clone());
            Collections.reverse(path);
        } else {
            for (int i = 0; i < t.length(); i++)
                for (char j = 'a'; j <= 'z'; j++) {
                    String r = t.substring(0, i) + j + t.substring(i + 1);
                    if (dist.containsKey(r) && dist.get(r) + 1 == dist.get(t)) {
                        path.add(r);
                        dfs(r);
                        path.remove(path.size() - 1);
                    }
                }
        }
    }

    public static void main(String[] args) {

        List<String> wordList = Build.build(new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        System.out.println((new Solution()).findLadders("hit", "cog", wordList));
    }
}
