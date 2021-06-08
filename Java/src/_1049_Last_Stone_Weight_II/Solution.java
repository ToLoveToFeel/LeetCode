package _1049_Last_Stone_Weight_II;

/**
 * Date: 2021/6/8 9:50
 * 执行用时：2 ms, 在所有 Java 提交中击败了99.07%的用户
 * 内存消耗：35.3 MB, 在所有 Java 提交中击败了99.35%的用户
 */
public class Solution {

    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int x : stones) sum += x;
        int m = sum / 2;
        int[] f = new int[m + 1];
        for (int x : stones)
            for (int j = m; j >= x; j--)
                f[j] = Math.max(f[j], f[j - x] + x);
        return (sum - f[m]) - f[m];
    }

    public static void main(String[] args) {

        int[] stones = {2, 7, 4, 1, 8, 1};
        System.out.println((new Solution()).lastStoneWeightII(stones));  // 1
    }
}
