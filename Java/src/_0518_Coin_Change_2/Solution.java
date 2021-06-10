package _0518_Coin_Change_2;

/**
 * Date: 2021/6/10 10:09
 */
public class Solution {

    public int change(int m, int[] coins) {
        int[] f = new int[m + 1];
        f[0] = 1;
        for (int v : coins)
            for (int j = v; j <= m; j++)
                f[j] += f[j - v];
        return f[m];
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).change(5, new int[]{1, 2, 5}));  // 4
    }
}
