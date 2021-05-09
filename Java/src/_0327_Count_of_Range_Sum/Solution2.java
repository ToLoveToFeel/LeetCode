package _0327_Count_of_Range_Sum;

import java.util.*;

/**
 * Date: 2020/11/7 15:55
 * Content:
 */
public class Solution2 {

    int m;  // 离散化后数据的个数
    int[] tr;  // 树状数组(下标从1开始)
    List<Long> alls = new ArrayList<>();  // 待离散化的数据，第一个数对应下标为1

    public int countRangeSum(int[] nums, int lower, int upper) {

        int n = nums.length;
        long[] s = new long[n + 1];
        alls.add(s[0]);
        for (int i = 1; i <= n; i++) {
            s[i] = s[i - 1] + nums[i - 1];
            alls.add(s[i]);
            alls.add(s[i] - lower);
            alls.add(s[i] - upper - 1);
        }
        // 离散化：排序、去重
        Collections.sort(alls);
        alls = alls.subList(0, unique(alls));

        m = alls.size();
        tr = new int[m + 1];

        int res = 0;
        add(get(s[0]), 1);
        for (int i = 1; i <= n; i++) {
            res += query(get(s[i] - lower)) - query(get(s[i] - upper - 1));
            add(get(s[i]), 1);
        }
        return res;
    }

    // 树状数组
    private int lowbit(int x) {
        return x & -x;
    }
    private void add(int x, int v) {
        for (int i = x; i <= m; i += lowbit(i)) tr[i] += v;
    }
    private int query(int x) {
        int res = 0;
        for (int i = x; i > 0; i -= lowbit(i)) res += tr[i];
        return res;
    }

    // 返回数据对应离散化后的值(从1开始)
    private int get(long x) {
        int l = 0, r = alls.size() - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (alls.get(mid) >= x) r = mid;
            else l = mid + 1;
        }
        return r + 1;
    }
    // 返回去重后应该保留的数据个数: Leetcode 0026 删除排序数组的重复项
    private int unique(List<Long> alls) {
        final int T = 1;
        int k = 0;
        for (int i = 0; i < alls.size(); i++)
            if (k - T < 0 || alls.get(i) != alls.get(k - T))
                alls.set(k++, alls.get(i));
        return k;
    }

    public static void main(String[] args) {

        System.out.println((new Solution2()).countRangeSum(new int[]{-2, 5, -1}, -2, 2));  // 3
    }
}
