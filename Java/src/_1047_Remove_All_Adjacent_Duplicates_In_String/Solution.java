package _1047_Remove_All_Adjacent_Duplicates_In_String;

import java.util.LinkedList;

/**
 * Created by WXX on 2021/3/9 8:59
 * 执行用时：20 ms, 在所有 Java 提交中击败了65.89%的用户
 * 内存消耗：38.7 MB, 在所有 Java 提交中击败了96.04%的用户
 */
public class Solution {

    public String removeDuplicates(String S) {

        char[] s = S.toCharArray();
        LinkedList<Character> stk = new LinkedList<>();
        for (char c : s) {
            stk.add(c);
            int p = stk.size() - 1;
            while (stk.size() >= 2 && stk.get(p).equals(stk.get(p - 1))) {
                stk.removeLast();
                stk.removeLast();
                p = stk.size() - 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : stk) sb.append(c);
        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).removeDuplicates("abbaca"));  // ca
    }
}
