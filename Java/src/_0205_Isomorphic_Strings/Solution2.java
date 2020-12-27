package _0205_Isomorphic_Strings;

/**
 * 时间复杂度：O(len(s))
 * 空间复杂度：O(len of charset)
 * 执行用时：5 ms, 在所有 Java 提交中击败了90.32%的用户
 * 内存消耗：38.5 MB, 在所有 Java 提交中击败了62.34%的用户
 */
public class Solution2 {

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
            if (map[s.charAt(i)]  == -1) {  // s[i]还未映射到其他字母
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
