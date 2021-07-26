package _1713_Minimum_Operations_to_Make_a_Subsequence;

import java.util.HashMap;

/**
 * Date: 2021/7/26 9:52
 * Content:
 * 执行用时：61 ms, 在所有 Java 提交中击败了87.30%的用户
 * 内存消耗：61 MB, 在所有 Java 提交中击败了9.52%的用户
 */
public class Solution {

    public static final int N = 100010;

    public int minOperations(int[] a, int[] b) {

        int n = a.length, m = b.length;
        HashMap<Integer, Integer> id = new HashMap<>();  // (a[i], i) 存储a中的元素在a中的位置
        for (int i = 0; i < n; i++) id.put(a[i], i);

        int[] q = new int[N];  // q[l]:记录长度为l的上升子序列最小的结尾值
        int res = 0;  // c的LIS, c是b中的每个元素在a中的位置 c.size() = b.size()
        for (int i = 0; i < m; i++) {
            if (!id.containsKey(b[i])) continue;
            int k = id.get(b[i]);
            // 在q中找到小于k的最大的数的位置
            int l = 0, r = res;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (q[mid] < k) l = mid;
                else r = mid - 1;
            }
            q[r + 1] = k;
            res = Math.max(res, r + 1);
        }
        return n - res;
    }

    public static void main(String[] args) {

        int[] a = {5, 1, 3}, b = {9, 4, 2, 3, 4};
        System.out.println((new Solution()).minOperations(a, b));  // 2
    }
}
