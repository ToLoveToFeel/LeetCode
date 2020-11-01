package _0140_Word_Break_II;

import java.util.*;

/**
 * Date: 2020/11/1 10:33
 * Content:
 * https://leetcode-cn.com/problems/word-break-ii/solution/dong-tai-gui-hua-hui-su-qiu-jie-ju-ti-zhi-python-d/
 * 动态规划
 * 状态：dp[i] 表示「长度」为 i 的 s 前缀子串可以拆分成 wordDict 中的单词，长度包括 0 ，因此状态数组的长度为 len + 1
 * 状态转移：dp[i] = true;
 */
public class Solution {
    /**
     * s[0:length) 如果可以拆分成 wordSet 中的单词，把递归求解的结果加入 res 中
     *
     * @param s       带分割的字符串
     * @param length  长度为 len 的 s 的前缀子串
     * @param wordSet 单词集合，已经加入哈希表
     * @param dp      预处理得到的 dp 数组
     * @param path    从叶子结点到根结点的路径
     * @param res     保存所有结果的变量
     */
    private void dfs(String s, int length, Set<String> wordSet, boolean[] dp, LinkedList<String> path, List<String> res) {
        if (length == 0) {
            res.add(String.join(" ", path));
            return;
        }

        // 可以拆分的左边界从 length - 1 依次枚举到 0
        for (int i = length - 1; i >= 0; i--) {
            String suffix = s.substring(i, length);  // 后缀
            if (wordSet.contains(suffix) && dp[i]) {
                path.addFirst(suffix);
                dfs(s, i, wordSet, dp, path, res);
                // 回溯
                path.removeFirst();
            }
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        // 为了快速判断一个单词是否在单词集合中，需要将它们加入哈希表
        Set<String> wordSet = new HashSet<>(wordDict);
        int length = s.length();

        // 第 1 步：动态规划计算是否有解
        boolean[] dp = new boolean[length + 1];
        dp[0] = true;  // 0 这个值需要被后面的状态值参考，如果一个单词正好在 wordDict 中，dp[0] 设置成 true 是合理的
        for (int right = 1; right <= length; right++) {
            // 如果单词集合中的单词长度都不长，从后向前遍历是更快的
            for (int left = right - 1; left >= 0; left--) {
                // substring 不截取 s[right]，dp[left] 的结果不包含 s[left]
                if (wordSet.contains(s.substring(left, right)) && dp[left]) {
                    dp[right] = true;
                    break;
                }
            }
        }

        // 第 2 步：回溯算法搜索所有符合条件的解
        List<String> res = new ArrayList<>();
        if (dp[length]) {
            LinkedList<String> path = new LinkedList<>();
            dfs(s, length, wordSet, dp, path, res);
            return res;
        }
        return res;
    }

    public static void main(String[] args) {
//        String s = "catsanddog";
//        List<String> wordDict = new ArrayList<String>() {{
//            add("cat");
//            add("cats");
//            add("and");
//            add("sand");
//            add("dog");
//        }};
        String s = "pineapplepenapple";
        List<String> wordDict = new ArrayList<String>() {{
            add("apple");
            add("pen");
            add("applepen");
            add("pine");
            add("pineapple");
        }};
        System.out.println((new Solution()).wordBreak(s, wordDict));
    }
}
