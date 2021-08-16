package _0526_Beautiful_Arrangement;

/**
 * Date: 2020/12/20 19:06
 * Content: 状态压缩dp : 需要计算的次数：2^15 * 15 = 491,520
 * f[i] : 这个 i 是一个状态，是一个长度为N为的二进制数(01串)，是0的话表示这个数没被用过，是1的话表示用过
 * 不能使用暴力解法，暴力解法需要计算的次数：15!*15 = 19,615,115,520,000 = 10 ^ 13
 * 执行用时：11 ms, 在所有 Java 提交中击败了93.17%的用户
 * 内存消耗：35.4 MB, 在所有 Java 提交中击败了48.25%的用户
 */
public class Solution {

    public int countArrangement(int n) {

        int[] f = new int[1 << n];
        f[0] = 1;
        for (int i = 0; i < (1 << n); i++) {
            int k = 0;  // k表示 状态i 中1的个数，表示下一个数据要放置的位置(索引)
            for (int j = 0; j < n; j++)
                if (((i >> j) & 1) == 1)
                    k++;
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) != 1) {  // 说明数据 j+1 没有被使用过，表示在索引为k+1的位置放置数据j+1
                    if ((k + 1) % (j + 1) == 0 || (j + 1) % (k + 1) == 0) {
                        f[i | 1 << j] += f[i];
                    }
                }
            }
        }
        return f[(1 << n) - 1];
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).countArrangement(2));
    }
}
