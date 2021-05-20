package _0692_Top_K_Frequent_Words;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Date: 2021/5/20 9:49
 * 执行用时：7 ms, 在所有 Java 提交中击败了91.95%的用户
 * 内存消耗：38.9 MB, 在所有 Java 提交中击败了10.45%的用户
 */
public class Solution {

    static class MyPair {
        String word;  // 单词
        int cnt;  // 单词出现的次数
        public MyPair(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        // 统计单词出现次数
        HashMap<String, Integer> hash = new HashMap<>();
        for (String w : words) hash.put(w, hash.getOrDefault(w, 0) + 1);
        // 将哈希表中的数据对放入List中
        List<MyPair> ws = new ArrayList<>();
        for (String key : hash.keySet()) ws.add(new MyPair(key, hash.get(key)));
        // 对List进行排序
        ws.sort((a, b) -> {
            if (a.cnt != b.cnt) return -(a.cnt - b.cnt);  // 降序
            return a.word.compareTo(b.word);  // 升序
        });
        // 得到结果
        List<String> res = new ArrayList<>();
        for (int i = 0; i < k; i++)
            res.add(ws.get(i).word);
        return res;
    }

    public static void main(String[] args) {

        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println((new Solution()).topKFrequent(words, 2));
    }
}
