package _0275_H_Index_II;

/**
 * Date: 2021/2/4 8:50
 * Content:
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：45.5 MB, 在所有 Java 提交中击败了19.18%的用户
 */
public class Solution {

    public int hIndex(int[] c) {

        int n = c.length;
        int l = 0, r = n;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (c[n - mid] >= mid) l = mid;
            else r = mid - 1;
        }
        return r;
    }

    public static void main(String[] args) {

        int[] c = {0, 1, 3, 5, 6};
        System.out.println((new Solution()).hIndex(c));  // 3
    }
}
