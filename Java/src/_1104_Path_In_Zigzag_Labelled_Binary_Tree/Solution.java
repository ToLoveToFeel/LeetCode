package _1104_Path_In_Zigzag_Labelled_Binary_Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Date: 2021/7/29 9:45
 * Content:
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：36.2 MB, 在所有 Java 提交中击败了21.59%的用户
 */
public class Solution {

    public List<Integer> pathInZigZagTree(int t) {
        int[] p = new int[25];
        p[0] = 1;
        for (int i = 1; i < 25; i++) p[i] = p[i - 1] * 2;

        int n = (int) (Math.log(t) / Math.log(2) + 1);
        List<Integer> res = new ArrayList<>();
        res.add(t);
        while (n > 1) {
            t = p[n - 2] + p[n - 1] - 1 - t / 2;
            res.add(t);
            n--;
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).pathInZigZagTree(14));  // [1, 3, 4, 14]
    }
}
