package _1002_Find_Common_Characters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Date: 2020/10/14 9:49
 * Content:
 */
public class Solution {
    public List<String> commonChars(String[] A) {
        int[] minFreq = new int[26];
        Arrays.fill(minFreq, Integer.MAX_VALUE);

        for (String word : A) {
            int[] freq = new int[26];
            // 统计 word 中各字符出现的次数
            for (int i = 0; i < word.length(); i++)
                freq[word.charAt(i) - 'a']++;
            // 更新结果
            for (int i = 0; i < 26; i++)
                minFreq[i] = Math.min(minFreq[i], freq[i]);
        }

        List<String> res = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < minFreq[i]; j++) {
                res.add(String.valueOf((char)(i + 'a')));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String[] A = {"bella", "label", "roller"};
        System.out.println((new Solution()).commonChars(A));
    }
}
