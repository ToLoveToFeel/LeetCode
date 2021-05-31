package _0401_Binary_Watch;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2021/5/31 15:13
 * 执行用时：13 ms, 在所有 Java 提交中击败了28.21%的用户
 * 内存消耗：38.4 MB, 在所有 Java 提交中击败了35.46%的用户
 */
public class Solution {

    public List<String> readBinaryWatch(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 1 << 10; i++) {
            int s = 0;
            for (int j = 0; j < 10; j++)
                if ((i >> j & 1) == 1)
                    s++;
            if (s == n) {
                int a = i >> 6, b = i & 63;
                if (a < 12 && b < 60) res.add(a + ":" + (b < 10 ? "0" + b : "" + b));
            }
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).readBinaryWatch(1));
    }
}
