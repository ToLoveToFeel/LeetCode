package _0065_Valid_Number;

/**
 * Date: 2021/6/17 10:11
 * 执行用时：2 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：38.5 MB, 在所有 Java 提交中击败了66.44%的用户
 */
public class Solution {

    public boolean isNumber(String s) {
        s = s.trim();
        if (s.length() == 0) return false;
        if (s.charAt(0) == '+' || s.charAt(0) == '-') s = s.substring(1);
        if (s.length() == 0) return false;
        char[] cs = s.toCharArray();
        if (cs[0] == '.' && (cs.length == 1 || cs[1] == 'e' || cs[1] == 'E'))
            return false;

        int dot = 0, e = 0;
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '.') {
                if (dot > 0 || e > 0) return false;
                dot++;
            } else if (cs[i] == 'e' || cs[i] == 'E') {
                if (i == 0 || i + 1 == cs.length || e > 0) return false;
                if (cs[i + 1] == '+' || cs[i + 1] == '-') {
                    if (i + 2 == cs.length) return false;
                    i++;
                }
                e++;
            } else if (cs[i] < '0' || cs[i] > '9') return false;
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).isNumber("0"));  // true
        System.out.println((new Solution()).isNumber("   "));  // false
    }
}
