package _1081_Smallest_Subsequence_of_Distinct_Characters;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * Date: 2020/12/2 16:35
 * Content: 单调栈
 * https://leetcode-cn.com/problems/remove-k-digits/solution/yi-zhao-chi-bian-li-kou-si-dao-ti-ma-ma-zai-ye-b-5/
 *
 * 执行用时：4 ms, 在所有 Java 提交中击败了64.13%的用户
 * 内存消耗：36.7 MB, 在所有 Java 提交中击败了64.20%的用户
 */
public class Solution {

    public String smallestSubsequence(String s) {

        if (s.length() <= 1)
            return s;

        // 第一步：统计各个小写字母出现的次数
        int[] letters = new int[26];
        for (char c : s.toCharArray()) {
            letters[c - 'a']++;
        }

        // 第二步：通过单调栈解决
        Deque<Character> stack = new ArrayDeque<>();  // 单调栈，不是完全单调的，因为要保证字符串中的字母至少出现一次
        Set<Character> set = new HashSet<>();  // set中存储着stack存在的小写字母
        for (char c : s.toCharArray()) {
            if (!set.contains(c)) {  // 如果stack中不存在字符c，才考虑入栈
                // 如果当前栈非空 && 当前考察元素<栈顶元素 && 栈顶元素在后续考察的元素中还存在
                // 只有这样才能删除栈顶元素
                while (!stack.isEmpty() && c < stack.peek() && letters[stack.peek() - 'a'] > 0) {
                    set.remove(stack.pop());
                }
                // 添加当前考察的字符
                set.add(c);
                stack.push(c);
            }
            // 对应字符次数减一
            letters[c - 'a'] -= 1;
        }

        // 第三步：得到结果
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {

        String s = "cbacdcbc";
        System.out.println((new Solution()).smallestSubsequence(s));
    }
}
