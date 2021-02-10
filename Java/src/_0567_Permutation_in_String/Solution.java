package _0567_Permutation_in_String;

/**
 * Date: 2021/2/10 9:50
 * Content:
 * 执行用时：12 ms, 在所有 Java 提交中击败了61.41%的用户
 * 内存消耗：38.6 MB, 在所有 Java 提交中击败了40.79%的用户
 */
public class Solution {

    int[] hash1 = new int[26], hash2 = new int[26];

    private boolean check(char c) {
        return hash1[c - 'a'] != 0 && hash1[c - 'a'] == hash2[c - 'a'];
    }

    public boolean checkInclusion(String s1, String s2) {

        int cnt1 = 0;
        for (char c : s1.toCharArray()) {
            if (hash1[c - 'a'] == 0) cnt1++;
            hash1[c - 'a']++;
        }
        for (int i = 0, j = 0, cnt2 = 0; i < s2.length(); i++) {
            if (check(s2.charAt(i))) cnt2--;
            hash2[s2.charAt(i) - 'a']++;
            if (check(s2.charAt(i))) cnt2++;

            if (i - j >= s1.length()) {
                if (check(s2.charAt(j))) cnt2--;
                hash2[s2.charAt(j) - 'a']--;
                if (check(s2.charAt(j))) cnt2++;
                j++;
            }
            if (cnt2 == cnt1) return true;
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).checkInclusion("ab", "eidbaooo"));  //  true
        System.out.println((new Solution()).checkInclusion("ab", "eidboaoo"));  //  false

    }
}
