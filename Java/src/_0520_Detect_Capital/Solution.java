package _0520_Detect_Capital;

/**
 * Date: 2020/12/18 9:26
 * Content: 三种情况：(1)全部都是大写字母；(2)全部都是小写字母；(3)只有一个大写字母且是首字母。
 * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：36.6 MB, 在所有 Java 提交中击败了92.97%的用户
 */
public class Solution {

    private boolean check(char c) {
        return c >= 'A' && c <= 'Z';
    }

    public boolean detectCapitalUse(String word) {

        int num = 0;  // 记录大写字母的数量
        for (char c : word.toCharArray()) {
            if (check(c)) {
                num++;
            }
        }

        return num == word.length() || num == 0 || (num == 1 && check(word.charAt(0)));
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).detectCapitalUse("USA"));  // true
        System.out.println((new Solution()).detectCapitalUse("flaG"));  // false
    }
}
