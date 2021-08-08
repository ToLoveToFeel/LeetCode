package _1137_N_th_Tribonacci_Number;

/**
 * Date: 2021/8/8 11:19
 * Content:
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：35.1 MB, 在所有 Java 提交中击败了70.79%的用户
 */
public class Solution {

    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n <= 2) return 1;
        int a = 0, b = 1, c = 1, d = 0;
        for (int i = 0; i < n - 2; i++) {
            d = a + b + c;
            a = b;
            b = c;
            c = d;
        }
        return d;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).tribonacci(4));  // 4
        System.out.println((new Solution()).tribonacci(25));  // 1389537
    }
}
