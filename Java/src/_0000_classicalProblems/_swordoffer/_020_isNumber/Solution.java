package _0000_classicalProblems._swordoffer._020_isNumber;

import java.util.HashMap;
import java.util.Map;

/**
 * Date: 2020/9/14 9:27
 * Content:
 * DFA：确定的有限状态自动机
 * https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/solution/mian-shi-ti-20-biao-shi-shu-zhi-de-zi-fu-chuan-y-2/
 */
public class Solution {
    public boolean isNumber(String s) {
        // (遇到的字符，转移后的状态)
        Map[] states = {
                new HashMap<Character, Integer>() {{ put(' ', 0); put('s', 1); put('d', 2); put('.', 4); }}, // 0.
                new HashMap<Character, Integer>() {{ put('d', 2); put('.', 4); }},                           // 1.
                new HashMap<Character, Integer>() {{ put('d', 2); put('.', 3); put('e', 5); put(' ', 8); }}, // 2.
                new HashMap<Character, Integer>() {{ put('d', 3); put('e', 5); put(' ', 8); }},              // 3.
                new HashMap<Character, Integer>() {{ put('d', 3); }},                                        // 4.
                new HashMap<Character, Integer>() {{ put('s', 6); put('d', 7); }},                           // 5.
                new HashMap<Character, Integer>() {{ put('d', 7); }},                                        // 6.
                new HashMap<Character, Integer>() {{ put('d', 7); put(' ', 8); }},                           // 7.
                new HashMap<Character, Integer>() {{ put(' ', 8); }}                                         // 8.
        };

        int curState = 0;  // 当前状态
        char curChar;  // 当前遇到的字符，并根据该字符进入下一状态

        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9')  // 数字
                curChar = 'd';
            else if (c == '+' || c == '-')  // 符号
                curChar = 's';
            else if (c == 'E' || c == 'e')  // 底数
                curChar = 'e';
            else if (c == ' ' || c == '.')
                curChar = c;
            else  // 遇到未定义的字符
                curChar = '?';
            if (!states[curState].containsKey(curChar))
                return false;
            curState = (int) states[curState].get(curChar);
        }

        return curState == 2 || curState == 3 || curState == 7 || curState == 8;
    }

    public static void main(String[] args) {
//        String s = "-1.e3";  // true
//        String s = "-.1e3";  // true
//        String s = "1e.3";  // false
//        String s = "1e5.3";  // false
//        String s = "1e-5.3";  // false
        String s = "0123";  // true
        System.out.println((new Solution()).isNumber(s));
    }
}
