package _0318_Maximum_Product_of_Word_Lengths;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2021/2/23 10:09
 * Content:
 * 执行用时：19 ms, 在所有 Java 提交中击败了42.38%的用户
 * 内存消耗：38.7 MB, 在所有 Java 提交中击败了41.77%的用户
 */
public class Solution {

    public int maxProduct(String[] words) {

        List<Integer> state = new ArrayList<>();
        for (String word : words) {
            int s = 0;
            for (char c : word.toCharArray())
                s |= 1 << (c - 'a');
            state.add(s);
        }

        int res = 0;
        for (int i = 0; i < words.length; i++)
            for (int j = i + 1; j < words.length; j++)
                if ((state.get(i) & state.get(j)) == 0)
                    res = Math.max(res, words[i].length() * words[j].length());
        return res;
    }

    public static void main(String[] args) {

        String[] words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        System.out.println((new Solution()).maxProduct(words));  // 16
    }
}
