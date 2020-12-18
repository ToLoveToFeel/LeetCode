package _0389_Find_the_Difference;

/**
 * Date: 2020/10/17 10:31
 * Content:
 * 位运算：异或，s和t所有元素进行异或，最后剩下的就是结果
 * 执行用时：2 ms, 在所有 Java 提交中击败了76.78%的用户
 * 内存消耗：36.7 MB, 在所有 Java 提交中击败了86.84%的用户
 */
public class Solution2 {

    public char findTheDifference(String s, String t) {

        char res = t.charAt(t.length() - 1);
        for (int i = 0; i < s.length(); i++) {
            res ^= s.charAt(i);
            res ^= t.charAt(i);
        }
        return res;
    }

    public static void main(String[] args) {

        String s = "abcd";
        String t = "abcde";
//        String s = "";
//        String t = "y";
        System.out.println((new Solution2()).findTheDifference(s, t));
    }
}
