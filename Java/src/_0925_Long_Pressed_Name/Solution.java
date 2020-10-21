package _0925_Long_Pressed_Name;

/**
 * Date: 2020/10/21 9:59
 * Content:
 */
public class Solution {
    public boolean isLongPressedName(String name, String typed) {
        if (typed.length() < name.length())
            return false;

        int p1 = 0, q1 = 1;  // 追踪 name 中相同字母的开始和结束位置 [p1...q1)
        int p2 = 0, q2 = 1;  // 追踪 typed 中相同字母的开始和结束位置 [p2...q2)
        while (p1 < name.length()) {
            char c = name.charAt(p1);
            if (p2 < typed.length() && c != typed.charAt(p2))
                return false;

            while (q1 < name.length() && name.charAt(q1) == c)
                q1++;
            while (q2 < typed.length() && typed.charAt(q2) == c)
                q2++;
            if ((q1 - p1) > (q2 - p2))  // name中字母的数目 > typed中字母字数
                return false;
            p1 = q1;
            p2 = q2;
        }
        return q2 == typed.length();  // 只有 typed 结束了才是正确结果
    }

    public static void main(String[] args) {
//        String name = "alex", typed = "aaleex";  // true
//        String name = "saeed", typed = "ssaaedd";  // false
//        String name = "leelee", typed = "lleeelee";  // true
//        String name = "laiden", typed = "laiden";  // true
        String name = "alex", typed = "alexxr";  // false
        System.out.println((new Solution()).isLongPressedName(name, typed));
    }
}
