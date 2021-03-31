package _0089_Gray_Code;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2021/3/31 11:02 下午
 * Content:
 * 执行用时：16 ms, 在所有 Java 提交中击败了9.85%的用户
 * 内存消耗：44.7 MB, 在所有 Java 提交中击败了84.58%的用户
 */
public class Solution {

    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        while (n-- != 0) {
            for (int i = res.size() - 1; i >= 0; i--) {
                res.set(i, res.get(i) * 2);
                res.add(res.get(i) + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).grayCode(2));
    }
}
