package _0668_Kth_Smallest_Number_in_Multiplication_Table;

/**
 * Created by WXX on 2021/3/3 10:57
 * 执行用时：19 ms, 在所有 Java 提交中击败了15.85%的用户
 * 内存消耗：35.4 MB, 在所有 Java 提交中击败了14.44%的用户
 */
public class Solution {

    private int get(int m, int n, int mid) {
        int res = 0;
        for (int i = 1; i <= n; i++)
            res += Math.min(m, mid / i);
        return res;
    }

    public int findKthNumber(int m, int n, int k) {

        int l = 1, r = n * m;
        while (l < r) {
            int mid = l + r >> 1;
            if (get(m, n, mid) >= k) r = mid;
            else l = mid + 1;
        }
        return r;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).findKthNumber(3, 3, 5));  // 3
        System.out.println((new Solution()).findKthNumber(2, 3, 6));  // 6
    }
}
