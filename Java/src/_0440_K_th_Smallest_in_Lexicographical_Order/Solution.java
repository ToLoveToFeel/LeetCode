package _0440_K_th_Smallest_in_Lexicographical_Order;

/**
 * Date: 2021/6/2 19:54
 * 执行用时：9 ms, 在所有 Java 提交中击败了6.70%的用户
 * 内存消耗：35.7 MB, 在所有 Java 提交中击败了5.50%的用户
 */
public class Solution {

    public int findKthNumber(int n, int k) {
        int prefix = 1;
        while (k > 1) {
            int cnt = f(prefix, n);
            if (k > cnt) {
                k -= cnt;
                prefix++;
            } else {
                k--;
                prefix *= 10;
            }
        }
        return prefix;
    }

    // 可以返回 1~n 中前缀是 prefix 数的个数
    private int f(int prefix, int n) {
        String A = "" + n, B = "" + prefix;
        int dt = A.length() - B.length();
        long p = 1;
        int res = 0;
        for (int i = 0; i < dt; i++) {
            res += p;
            p *= 10;
        }
        A = A.substring(0, B.length());
        if (A.compareTo(B) == 0) res += n - prefix * p + 1;
        else if (A.compareTo(B) > 0) res += p;
        return res;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).findKthNumber(13, 2));  // 10
    }
}
