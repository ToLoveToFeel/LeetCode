package _1178_Number_of_Valid_Words_for_Each_Puzzle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by WXX on 2021/2/26 10:10
 * 执行用时：131 ms, 在所有 Java 提交中击败了15.22%的用户
 * 内存消耗：53.7 MB, 在所有 Java 提交中击败了28.26%的用户
 */
public class Solution {

    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {

        HashMap<Integer, Integer> hash = new HashMap<>();  // (word的二进制表示(1代表有该字母)，次数)
        for (String word : words) {
            int s = 0;
            for (char c : word.toCharArray())
                s |= 1 << (c - 'a');
            hash.put(s, hash.getOrDefault(s, 0) + 1);
        }

        List<Integer> res = new ArrayList<>(puzzles.length);
        for (String ps : puzzles) {
            char[] p = ps.toCharArray();
            int cnt = 0;
            for (int mask = 0; mask < (1 << 6); mask++) {
                int s = 1 << (p[0] - 'a');
                for (int i = 0; i < 6; i++)
                    if ((mask & (1 << i)) != 0)
                        s |= 1 << (p[i + 1] - 'a');
                cnt += hash.getOrDefault(s, 0);
            }
            res.add(cnt);
        }
        return res;
    }

    public static void main(String[] args) {

        String[] words = {"aaaa", "asas", "able", "ability", "actt", "actor", "access"};
        String[] puzzles = {"aboveyz", "abrodyz", "abslute", "absoryz", "actresz", "gaswxyz"};
        System.out.println((new Solution()).findNumOfValidWords(words, puzzles));
    }
}
