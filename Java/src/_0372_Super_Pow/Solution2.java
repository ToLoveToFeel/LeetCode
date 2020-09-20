package _0372_Super_Pow;

/**
 * Date: 2020/9/20 11:36
 * Content:
 * 请参照 classicalproblems: fastpower, fastpowermod
 */
public class Solution2 {
    // (a ^ b) % c
    private int fastPowMod(int a, int b, int c) {
        int res = 1;
        a = a % c;
        while (b != 0) {
            if ((b & 1) == 1) {
                res = (res * a) % c;
            }
            b >>= 1;
            a = (a * a) % c;
        }
        return res;
    }

    // (a ^ b) % c
    public int superPow(int a, int[] b) {
        int res = 1;
        int c = 1337;
        int index = b.length - 1;
        a = a % c;
        while (index >= 0) {
            if (b[index] != 0) {
                res = (res * fastPowMod(a, b[index], c)) % c;
            }
            index--;  // 十进制下数据右移一位，相当于 底数 10 次幂
            a = fastPowMod(a, 10, c);
        }
        return res;
    }

    public static void main(String[] args) {
//        int a = 2;
//        int[] b = {1,5};
        int a = 2147483647;
        int[] b = {2, 0, 0};
        System.out.println((new Solution2()).superPow(a, b));
    }
}
