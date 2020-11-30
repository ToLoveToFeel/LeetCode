package _0767_Reorganize_String;

/**
 * Date: 2020/11/30 9:09
 * Content: 这种做法是错误的，请看Solution2
 *
 */
public class Solution {

    public String reorganizeString(String S) {

        if (S.length() <= 1)
            return S;

        int[] letters = new int[26];
        for (char c : S.toCharArray()) {
            letters[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        char pre = S.charAt(0);
        sb.append(pre);
        letters[pre - 'a']--;
        boolean flag = false;  // 记录是否添加成功

        for (int i = 1; i < S.length(); i++) {
            for (int j = 0; j < 26; j++) {
                char cur = (char) (j + 'a');
                if (letters[j] != 0 && pre != cur) {
                    letters[j]--;
                    sb.append(cur);
                    pre = cur;
                    flag = true;
                }
            }
            if (!flag) {
                return "";
            } else {
                flag = false;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        String S = "vvvlo";  // 正确答案是"vlvol"，但这种方式的输出为""
        System.out.println((new Solution()).reorganizeString(S));

    }
}
