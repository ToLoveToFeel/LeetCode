package _0678_Valid_Parenthesis_String;

/**
 * Created by WXX on 2021/3/7 19:44
 */
public class Solution {

    public boolean checkValidString(String s) {
        int low = 0, high = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                low++; high++;
            } else if (c == ')') {
                low--; high--;
            } else {
                low--; high++;
            }
            low = Math.max(low, 0);
            if (low > high) return false;
        }
        return low == 0;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).checkValidString("()"));  // true
        System.out.println((new Solution()).checkValidString("(*)"));  // true
        System.out.println((new Solution()).checkValidString("(*))"));  // true
    }
}
