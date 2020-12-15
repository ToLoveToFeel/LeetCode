package _0648_Replace_Words;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Date: 2020/12/15 14:34
 * Content: 使用 字符串哈希 解决，具体信息请查看：https://www.acwing.com/activity/content/11/
 * 还可以使用 Trie 解决
 * 执行用时：48 ms, 在所有 Java 提交中击败了33.09%的用户
 * 内存消耗：43.4 MB, 在所有 Java 提交中击败了76.94%的用户
 */
public class Solution {

    public static final int P = 131;  // 或者 13331

    public String replaceWords(List<String> dictionary, String sentence) {

        // 将字典里的数据通过 字符串哈希 存入集合中
        HashSet<Long> set = new HashSet<>();
        for (String s : dictionary) {
            long h = 0;
            for (char c : s.toCharArray()) {
                h = h * P + c;
            }
            set.add(h);
        }

        String[] words = sentence.split("\\s");  // 根据空格(可以有多个)拆分为多个单词
        StringBuilder res = new StringBuilder();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            long h = 0;
            for (char c : word.toCharArray()) {
                sb.append(c);
                h = h * P + c;
                if (set.contains(h))
                    break;
            }
            res.append(sb.append(' '));
        }

        return res.substring(0, res.length() - 1);
    }

    public static void main(String[] args) {

        List<String> dictionary = new ArrayList<>();
        dictionary.add("cat");
        dictionary.add("bat");
        dictionary.add("rat");
        String sentence = "the cattle was rattled by the battery";
        System.out.println((new Solution()).replaceWords(dictionary, sentence));
    }
}
