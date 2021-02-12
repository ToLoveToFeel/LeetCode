package _0119_Pascal_s_Triangle_II;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2020/9/21 18:48
 * Content:
 * <p>
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：36 MB, 在所有 Java 提交中击败了88.26%的用户
 */
public class Solution {

    public List<Integer> getRow(int n) {

        List<Integer> res = new ArrayList<>();
        res.add(1);
        for (int i = 1; i <= n; i++) {
            long t = ((long) res.get(i - 1)) * (n - i + 1) / i;
            res.add((int) t);
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).getRow(0));
        System.out.println((new Solution()).getRow(3));
    }
}
