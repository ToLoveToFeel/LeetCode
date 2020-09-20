package _0000_study.classicalproblems.fastpowermod;

/**
 * Date: 2020/9/20 10:15
 * Content:
 */
public class FastPowerMod {
    // (a ^ b) % c
    public int fastPowerMod(int a, int b, int c) {
        int res = 1;
        a = a % c;  // 对刚进来的a进行取模运算，避免后面第一次求平方运算溢出
        while (b != 0) {
            if ((b & 1) == 1) {
                res = (res * a) % c;
            }
            b >>= 1;
            a = (a * a) % c;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println((new FastPowerMod()).fastPowerMod(2, 1000000000, 1000));
    }
}
