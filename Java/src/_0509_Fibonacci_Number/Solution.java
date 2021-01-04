package _0509_Fibonacci_Number;

/**
 * Date: 2021/1/4 9:45
 * Content:
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：35 MB, 在所有 Java 提交中击败了80.42%的用户
 */
public class Solution {

    public int fib(int n) {

        if (n == 0) return 0;
        if (n == 1) return 1;

        int pp = 0, p = 1, res = 0;
        for (int i = 2; i <= n; i++) {
            res = pp + p;
            pp = p;
            p = res;
        }

        return res;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).fib(2));  // 1
        System.out.println((new Solution()).fib(3));  // 2
    }
}
