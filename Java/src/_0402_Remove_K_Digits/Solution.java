package _0402_Remove_K_Digits;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Date: 2020/11/15 11:27
 * Content: 栈(单调递增栈)
 * https://leetcode-cn.com/problems/remove-k-digits/solution/yi-zhao-chi-bian-li-kou-si-dao-ti-ma-ma-zai-ye-b-5/
 *
 * 执行用时：12 ms, 在所有 Java 提交中击败了39.25%的用户
 * 内存消耗：39.1 MB, 在所有 Java 提交中击败了33.83%的用户
 */
public class Solution {

    public String removeKdigits(String num, int k) {
        if (num.length() == k)
            return "0";

        // 利用单调栈解决
        Deque<Character> stack = new ArrayDeque<>();
        int len = num.length() - k;  // 最终数据的长度
        for (char c : num.toCharArray()) {
            // 还要删除字符 && 栈非空 && 当前考察的元素<栈顶元素
            while (k > 0 && !stack.isEmpty() && c < stack.peek()){
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        String res = sb.reverse().substring(0, len).replaceAll("^(0+)", "");
        return res.equals("") ? "0" : res;
    }

    public static void main(String[] args) {

//        String num = "1432219";  // 1219
//        int k = 3;
//        System.out.println((new Solution()).removeKdigits(num, k));
//        String num = "100200";  // 200
//        int k = 1;
//        System.out.println((new Solution()).removeKdigits(num, k));
        String num = "10";  // 0
        int k = 1;
        System.out.println((new Solution()).removeKdigits(num, k));
    }
}
