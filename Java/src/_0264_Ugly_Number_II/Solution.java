package _0264_Ugly_Number_II;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2021/2/2 19:21
 * Content: 实质：三路归并
 * 设丑数的集合为S，则有 S = 2 * S, S = 3 * S, S = 5 * S
 * 执行用时：8 ms, 在所有 Java 提交中击败了33.18%的用户
 * 内存消耗：38.1 MB, 在所有 Java 提交中击败了12.74%的用户
 */
public class Solution {

    public int nthUglyNumber(int n) {

        List<Integer> q = new ArrayList<>();
        q.add(1);
        for (int i = 0, j = 0, k = 0; q.size() < n; ) {
            int t = Math.min(q.get(i) * 2, Math.min(q.get(j) * 3, q.get(k) * 5));
            q.add(t);
            if (q.get(i) * 2 == t) i++;
            if (q.get(j) * 3 == t) j++;
            if (q.get(k) * 5 == t) k++;
        }
        return q.get(q.size() - 1);
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).nthUglyNumber(10));  // 12
    }
}
