package _1482_Minimum_Number_of_Days_to_Make_m_Bouquets;

import java.util.Arrays;

/**
 * Date: 2021/5/9 10:28
 * 执行用时：23 ms, 在所有 Java 提交中击败了37.06%的用户
 * 内存消耗：47.4 MB, 在所有 Java 提交中击败了19.41%的用户
 */
public class Soltuion {
    public int minDays(int[] w, int m, int k) {

        if (m * k > w.length) return -1;
        int l = 1, r = Arrays.stream(w).max().getAsInt();
        while (l < r) {
            int mid = l + r >> 1;
            if (check(w, mid, m, k)) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    private boolean check(int[] w, int days, int m, int k) {
        int res = 0, cnt = 0;
        for (int x : w) {
            cnt = x <= days ? cnt + 1 : 0;
            if (cnt == k) {
                res++;
                cnt = 0;
            }
        }
        return res >= m;
    }

    public static void main(String[] args) {

        System.out.println((new Soltuion()).minDays(new int[]{1, 10, 3, 10, 2}, 3, 1));  // 3
    }
}
