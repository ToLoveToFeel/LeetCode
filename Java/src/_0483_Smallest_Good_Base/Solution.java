package _0483_Smallest_Good_Base;

/**
 * Date: 2021/6/18 17:17
 * 执行用时：5 ms, 在所有 Java 提交中击败了14.10%的用户
 * 内存消耗：36.6 MB, 在所有 Java 提交中击败了66.67%的用户
 */
public class Solution {

    public String smallestGoodBase(String n) {
        long N = Long.parseLong(n);
        for (int t = (int) (Math.log(N) / Math.log(2) + 1); t >= 3; t--) {
            long k = (long) Math.pow(N, 1.0 / (t - 1));
            long r = 0;
            for (int i = 0; i < t; i++) r = r * k + 1;
            if (r == N) return k + "";
        }
        return String.valueOf(N - 1);
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).smallestGoodBase("13"));  // 3
        System.out.println((new Solution()).smallestGoodBase("1000000000000000000"));  // 999999999999999999
    }
}
