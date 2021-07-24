package _1736_Latest_Time_by_Replacing_Hidden_Digits;

/**
 * Date: 2021/7/24 9:43
 * Content:
 */
public class Solution {

    public String maximumTime(String time) {
        char[] t = time.toCharArray();
        // 处理小时
        if (t[0] == '?' && t[1] == '?') {
            t[0] = '2';
            t[1] = '3';
        } else if (t[0] == '?') {
            if (t[1] <= '3') t[0] = '2';
            else t[0] = '1';
        } else if (t[1] == '?') {
            if (t[0] <= '1') t[1] = '9';
            else t[1] = '3';
        }
        // 处理分钟
        if (t[3] == '?') t[3] = '5';
        if (t[4] == '?') t[4] = '9';

        return new String(t);
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).maximumTime("2?:?0"));  // 23:50
        System.out.println((new Solution()).maximumTime("0?:3?"));  // 09:39
        System.out.println((new Solution()).maximumTime("1?:22"));  // 19:22
    }
}
