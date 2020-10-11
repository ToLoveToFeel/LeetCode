package _0038_Count_and_Say;

import _0000_study._datastructure.map.Map;

import java.util.HashMap;

/**
 * Date: 2020/10/11 10:02
 * Content:
 */
public class Solution {
    public String countAndSay(int n) {
        if (!(n > 0 && n <= 30))
            throw new IllegalArgumentException("PInput Error!");

        HashMap<Integer, String> map = new HashMap<Integer, String>() {{
            put(1, "1");
            put(2, "11");
            put(3, "21");
            put(4, "1211");
            put(5, "111221");
        }};
        if (n <= 5)
            return map.get(n);

        for (int i = 6; i <= n; i++) {
            String s = map.get(i - 1);
            int j = 0;
            StringBuilder sb = new StringBuilder();
            while (j < s.length()) {
                char c = s.charAt(j);
                int k = j + 1;
                while (k < s.length() && c == s.charAt(k)) {
                    k++;
                }
                int count = k - j;
                sb.append(count);
                sb.append(c);
                j = k;
            }
            map.put(i, sb.toString());
        }
//        for (int i = 1; i <= n; i++) {
//            System.out.println("put(" + i + ", \"" + map.get(i) + "\");");
//        }

        return map.get(n);
    }

    public static void main(String[] args) {
        System.out.println((new Solution()).countAndSay(6));
    }
}
