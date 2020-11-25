package _1370_Increasing_Decreasing_String;

/**
 * Date: 2020/11/25 18:57
 * Content: 哈希表
 * 执行用时：4 ms, 在所有 Java 提交中击败了45.61%的用户
 * 内存消耗：38.5 MB, 在所有 Java 提交中击败了77.24%的用户
 */
public class Solution {

    public String sortString(String s) {

        if (s.length() <= 1)
            return s;

        // 第一步：统计字母出现次数
        int[] letters = new int[26];  // 记录各个小写字母出现次数
        for (char c : s.toCharArray()) {
            letters[c - 'a']++;
        }

        // 第二步，根据题目描述步骤得到结果
        StringBuilder sb = new StringBuilder();
        while (sb.length() != s.length()) {
            // 寻找严格上升序列
            for (int i = 0; i < 26; i++) {
                if (letters[i] != 0) {
                    char c = (char) (i + 'a');
                    sb.append(c);
                    letters[i]--;
                }
            }
            // 寻找严格下降序列
            for (int i = 25; i >= 0; i--) {
                if (letters[i] != 0) {
                    char c = (char) (i + 'a');
                    sb.append(c);
                    letters[i]--;
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {

//        String s = "aaaabbbbcccc";  // abccbaabccba
//        String s = "rat";  // art
//        String s = "leetcode";  // cdelotee
//        String s = "ggggggg";  // ggggggg
        String s = "spo";  // ops
        System.out.println((new Solution()).sortString(s));
    }
}
