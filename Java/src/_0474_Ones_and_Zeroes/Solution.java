package _0474_Ones_and_Zeroes;

/**
 * Date: 2021/6/6 10:56
 */
public class Solution {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] f = new int[m + 1][n + 1];
        for (String str : strs) {
            int a = 0, b = 0;
            for (char c : str.toCharArray())
                if (c == '0') a++;
                else b++;
            for (int i = m; i >= a; i--)
                for (int j = n; j >= b; j--)
                    f[i][j] = Math.max(f[i][j], f[i - a][j - b] + 1);
        }
        return f[m][n];
    }

    public static void main(String[] args) {

        String[] strs = {"10", "0001", "111001", "1", "0"};
        System.out.println((new Solution()).findMaxForm(strs, 5, 3));  // 4
    }
}
