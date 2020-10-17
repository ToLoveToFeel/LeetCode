package _0389_Find_the_Difference;

/**
 * Date: 2020/10/17 10:31
 * Content:
 * 位运算：异或，s和t所有元素进行异或，最后剩下的就是结果
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
