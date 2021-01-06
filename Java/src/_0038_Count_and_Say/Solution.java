package _0038_Count_and_Say;

import java.util.HashMap;
import java.util.Map;

/**
 * Date: 2020/10/11 10:02
 * Content:
 */
public class Solution {

    public String countAndSay(int n) {

        Map<Integer, String> map = new HashMap<Integer, String>() {{
            put(1, "1");
            put(2, "11");
            put(3, "21");
            put(4, "1211");
            put(5, "111221");
        }};
        if (n <= 5) return map.get(n);

        for (int i = 6; i <= n; i++) {
            String s = map.get(i - 1);
            int j = 0;
            StringBuilder sb = new StringBuilder();
            while (j < s.length()) {

                char c = s.charAt(j);
                int k = j + 1;
                while (k < s.length() && c == s.charAt(k)) k++;
                int count = k - j;
                sb.append(count);
                sb.append(c);
                j = k;
            }
            map.put(i, sb.toString());
        }

        return map.get(n);
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).countAndSay(6));
    }
}
