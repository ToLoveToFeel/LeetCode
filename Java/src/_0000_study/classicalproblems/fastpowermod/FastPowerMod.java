package _0000_study.classicalproblems.fastpowermod;

/**
 * Date: 2020/9/20 10:15
 * Content:
 */
public class FastPowerMod {
    // (a ^ b) % c
    public int fastPowerMod(int a, int b, int c) {
        int res = 1;
        while (b != 0) {
            if ((b & 1) == 1) {
                res = (res * a) % c;
            }
            b /= 2;
            a = (a * a) % c;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println((new FastPowerMod()).fastPowerMod(2, 1000000000, 1000));
    }
}
