package _0171_Excel_Sheet_Column_Number;

/**
 * Date: 2021/6/29 14:19
 */
public class Solution {

    public int titleToNumber(String s) {
        char[] cs = s.toCharArray();
        int res = 0;
        for (int i = 0; i < cs.length; i++)
            res = res * 26 + (cs[i] - 'A' + 1);
        return res;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).titleToNumber("A"));  // 1
        System.out.println((new Solution()).titleToNumber("AB"));  // 28
        System.out.println((new Solution()).titleToNumber("ZY"));  // 701
    }
}
