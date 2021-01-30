package _0290_Word_Pattern;

import java.util.HashMap;

/**
 * 执行用时：1 ms, 在所有 Java 提交中击败了98.87%的用户
 * 内存消耗：36.5 MB, 在所有 Java 提交中击败了69.97%的用户
 */
public class Solution {

    public boolean wordPattern(String p, String s) {

        String[] words = s.split(" ");  // 分割字符串

        if (p.length() != words.length) return false;

        HashMap<Character, String> pw = new HashMap<>();  // (p[i], words[i])
        HashMap<String, Character> wp = new HashMap<>();  // (words[i], p[i])

        for (int i = 0; i < p.length(); i++) {
            char a = p.charAt(i);
            String b = words[i];
            if (pw.containsKey(a) && !pw.get(a).equals(b)) return false;
            pw.put(a, b);
            if (wp.containsKey(b) && wp.get(b) != a) return false;
            wp.put(b, a);
        }

        return true;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).wordPattern("abba", "dog cat cat dog"));  // true
        System.out.println((new Solution()).wordPattern("abba", "dog cat cat fish"));  // false
        System.out.println((new Solution()).wordPattern("aaaa", "dog cat cat dog"));  // false
        System.out.println((new Solution()).wordPattern("abba", "dog dog dog dog"));  // false
    }
}
