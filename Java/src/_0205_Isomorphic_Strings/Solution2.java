// Author  :  Wang Xiaoxiao
// Time    :  2020-01-26
package _0205_Isomorphic_Strings;

public class Solution2 {
    // 时间复杂度：O(len(s))
    // 空间复杂度：O(len of charset)
    public boolean isIsomorphic(String s, String t) {
        assert s.length() == t.length();

        if (s.length() == 0 || s.length() == 1)
            return true;

        int[] map = new int[256];  // 负责字母映射（从s到t)
        boolean[] mapped = new boolean[256];  // 负责记录t中字符是否被别的字符映射过
        for (int i = 0; i < map.length; i++) {
            map[i] = -1;
            mapped[i] = false;
        }

        for (int i = 0; i < s.length(); i++)
            if (-1 == map[s.charAt(i)]) {  // s[i]还未映射到其他字母
                if (mapped[t.charAt(i)])  // t[i]被别的字母所映射过了
                    return false;
                map[s.charAt(i)] = t.charAt(i);
                mapped[t.charAt(i)] = true;
            }
            else if(map[s.charAt(i)] != t.charAt(i))
                return false;

        return true;
    }

    public static void main(String[] args) {
        System.out.println((new Solution2()).isIsomorphic("egg", "add"));
        System.out.println((new Solution2()).isIsomorphic("foo", "bar"));
        System.out.println((new Solution2()).isIsomorphic("paper", "title"));
        System.out.println((new Solution2()).isIsomorphic("ab", "aa"));
    }
}
