package _1662_Check_If_Two_String_Arrays_are_Equivalent;

/**
 * Date: 2020/12/20 19:40
 * Content:
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：36.5 MB, 在所有 Java 提交中击败了59.40%的用户
 */
public class Solution {

    private String concat(String[] words) {

        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word);
        }
        return sb.toString();
    }

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {

        String s1 = concat(word1);
        String s2 = concat(word2);

        return s1.equals(s2);
    }

    public static void main(String[] args) {

        String[] word1 = {"abc", "d", "defg"};
        String[] word2 = {"abcddefg"};
        System.out.println((new Solution()).arrayStringsAreEqual(word1, word2));
    }
}
