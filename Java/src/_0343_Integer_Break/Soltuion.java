package _0343_Integer_Break;

/**
 * Date: 2021/5/10 21:53
 */
public class Soltuion {

    public int integerBreak(int n) {
        if (n <= 3) return 1 * (n - 1);
        int p = 1;
        while (n >= 5) { n -= 3; p *= 3; }  // 结束循环后n只可能为2、3或者4
        return p * n;
    }

    public static void main(String[] args) {

        System.out.println((new Soltuion()).integerBreak(2));  // 1
    }
}
