package _0274_H_Index;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * Date: 2021/2/3 11:31
 * Content:
 * 执行用时：1 ms, 在所有 Java 提交中击败了84.51%的用户
 * 内存消耗：36.4 MB, 在所有 Java 提交中击败了28.11%的用户
 */
public class Solution {

    public int hIndex(int[] c) {

        Arrays.sort(c);
        for (int h = c.length; h > 0; h--)
            if (c[c.length - h] >= h)
                return h;
        return 0;
    }

    public static void main(String[] args) {

        int[] c = {3, 0, 6, 1, 5};
        System.out.println((new Solution()).hIndex(c));  // 3
        TreeSet<Long> S = new TreeSet<Long>();
        S.add(1l);
        S.add(1l);
        S.add(1l);
        System.out.println(S.size());
    }
}
