package _0423_Reconstruct_Original_Digits_from_English;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Date: 2021/6/1 9:15
 * 执行用时：39 ms, 在所有 Java 提交中击败了9.67%的用户
 * 内存消耗：38.9 MB, 在所有 Java 提交中击败了73.42%的用户
 */
public class Solution {

    static String[] name = {
            "zero", "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine"
    };
    static int[] ord = {0, 8, 3, 2, 6, 4, 5, 1, 7, 9};
    HashMap<Character, Integer> cnt = new HashMap<>();

    public String originalDigits(String s) {
        for (char c : s.toCharArray()) cnt.put(c, cnt.getOrDefault(c, 0) + 1);
        StringBuilder sb = new StringBuilder();
        for (int x : ord) {
            while (true) {
                boolean flag = true;
                for (char c : name[x].toCharArray())
                    if (cnt.getOrDefault(c, 0) == 0) {
                        flag = false;
                        break;
                    }
                if (flag) {
                    sb.append(x);
                    for (char c : name[x].toCharArray()) cnt.put(c, cnt.get(c) - 1);
                } else break;
            }
        }
        return sort(sb.toString());
    }

    private String sort(String s) {
        char[] chs = s.toCharArray();
        Arrays.sort(chs);
        return new String(chs);
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).originalDigits("owoztneoer"));  // 012
    }
}
