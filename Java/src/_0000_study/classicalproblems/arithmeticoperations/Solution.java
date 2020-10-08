package _0000_study.classicalproblems.arithmeticoperations;

/**
 * Date: 2020/10/8 11:00
 * Content:
 */
public class Solution {
    // return a + b 加
	public int getSum(int a, int b) {
        while (b != 0) {
            int x = a, y = b;
            a = (x ^ y);
            b = ((x & y) << 1);
        }

        return a;
    }

    // return -a 相反数
    public int getOpposite(int a) {
	    return getSum(~a, 1);
    }

    // return a - b 减
    public int getSubtract(int a, int b) {
	    return getSum(a, getOpposite(b));
    }

    // 辅助函数，返回两个正整数的乘积
    private int getPositiveMul(int a, int b) {
	    int res = 0;
	    while (b != 0) {
	        if ((b & 1) == 1)
	            res = getSum(res, a);
	        a <<= 1;
	        b >>= 1;
        }
	    return res;
    }

    // return a * b 乘
    public int getMul(int a, int b) {
	    if (a == 0 || b == 0)
	        return 0;

	    if (a > 0 && b > 0)
	        return getPositiveMul(a, b);
	    else if (a > 0)  // 说明 b < 0
	        return getOpposite(getPositiveMul(a, getOpposite(b)));
	    else if (b > 0)  // 说明 a < 0
	        return getOpposite(getPositiveMul(getOpposite(a), b));
	    else // 说明 a < 0, b < 0
            return getPositiveMul(getOpposite(a), getOpposite(b));
    }

    // 辅助函数，返回两个正整数的除法
    public int getPositiveDiv(int a, int b) {
	    int res = 0;
	    while (a >= b) {
	        a = getSubtract(a, b);
	        res = getSum(res, 1);
        }
	    return res;
    }

    // return a / b 整数除法
    public int getDiv(int a, int b) {
	    if (b == 0)
	        throw new IllegalArgumentException("Divisor can not equal zero!!!");
	    if (a == 0)
	        return 0;

        if (a > 0 && b > 0)
            return getPositiveDiv(a, b);
        else if (a > 0)  // 说明 b < 0
            return getOpposite(getPositiveDiv(a, getOpposite(b)));
        else if (b > 0)  // 说明 a < 0
            return getOpposite(getPositiveDiv(getOpposite(a), b));
        else // 说明 a < 0, b < 0
            return getPositiveDiv(getOpposite(a), getOpposite(b));
    }

    public static void main(String[] args) {
	    Solution solution = new Solution();

	    // 加
        System.out.println(solution.getSum(11, 13));
        System.out.println();
        // 减
        System.out.println(solution.getSubtract(11, 13));
        System.out.println();
        // 乘
        System.out.println(solution.getMul(11, 13));
        System.out.println(solution.getMul(-11, 13));
        System.out.println(solution.getMul(11, -13));
        System.out.println(solution.getMul(-11, -13));
        System.out.println();
        // 除
        System.out.println(solution.getDiv(10, 3));
        System.out.println(solution.getDiv(-10, 3));
        System.out.println(solution.getDiv(10, -3));
        System.out.println(solution.getDiv(-10, -3));
    }
}
