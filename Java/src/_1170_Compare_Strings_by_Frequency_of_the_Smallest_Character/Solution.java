package _1170_Compare_Strings_by_Frequency_of_the_Smallest_Character;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Date: 2020/12/1 15:42
 * Content: 计数排序、前缀和
 * <p>
 * 执行用时：2 ms, 在所有 Java 提交中击败了98.98%的用户
 * 内存消耗：38.5 MB, 在所有 Java 提交中击败了91.87%的用户
 * 第一次Leetcode提交自己的解答
 */
public class Solution {

    // 题目中描述的 f 函数
    private int f(String s) {

        int res = 0;
        char minChar = 'z';
        for (char c : s.toCharArray()) {
            if (c < minChar) {
                minChar = c;
                res = 1;
            } else if (c == minChar) {
                res++;
            }
        }
        return res;
    }

    public int[] numSmallerByFrequency(String[] queries, String[] words) {

        // 第一步：计算各个字符串的 f 值，存入数组中
        int[] queriesF = new int[queries.length];
        int[] wordsF = new int[words.length];
        for (int i = 0; i < queries.length; i++) {
            queriesF[i] = f(queries[i]);
        }
        for (int i = 0; i < words.length; i++) {
            wordsF[i] = f(words[i]);
        }

        // 第二步：对wordsF计数排序，并计算前缀和
        // 1 <= queries[i].length, words[i].length <= 10
        int[] count = new int[11];  // count[i] 代表 i 出现的次数
        for (int value : wordsF) {
            count[value]++;
        }
        int[] sum = new int[11];  // sum[i] 代表 count[0..i]之和，前缀和
        for (int i = 1; i < 11; i++) {
            sum[i] = sum[i - 1] + count[i];
        }

        // 第三步：计算结果
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            // count[0..10] - count[0..queriesF[i]] = count[queriesF[i]+1..10]
            res[i] = sum[10] - sum[queriesF[i]];
        }

        return res;
    }

    public static void main(String[] args) {

        String[] queries = {"bbb", "cc"};
        String[] words = {"a", "aa", "aaa", "aaaa"};
        int[] res = (new Solution()).numSmallerByFrequency(queries, words);

        System.out.println(Arrays.stream(res).boxed().collect(Collectors.toList()));
    }
}
