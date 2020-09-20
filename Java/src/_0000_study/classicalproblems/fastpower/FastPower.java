package _0000_study.classicalproblems.fastpower;

/**
 * Date: 2020/9/20 11:10
 * Content:
 */
public class FastPower {
    // a ^ b
    public int fastPower(int a, int b) {
        int res = 1;
        while (b != 0) {
            if ((b & 1) == 1) {
                res = res * a;
            }
            b /= 2;
            a = a * a;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println((new FastPower()).fastPower(2, 20));
    }
}
