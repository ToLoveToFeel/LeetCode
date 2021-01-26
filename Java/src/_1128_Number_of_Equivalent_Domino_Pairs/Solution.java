package _1128_Number_of_Equivalent_Domino_Pairs;

/**
 * Date: 2021/1/26 10:36
 * Content:
 * 执行用时：3 ms, 在所有 Java 提交中击败了85.51%的用户
 * 内存消耗：47.6 MB, 在所有 Java 提交中击败了63.17%的用户
 */
public class Solution {

    // C(n, 2) = 1 + 2 + 3 + ... + (n - 1)
    public int numEquivDominoPairs(int[][] dominoes) {

        int[] hash = new int[100];
        int res = 0;
        for (int[] d : dominoes) {
            int t = d[0] >= d[1] ? d[0] * 10 + d[1] : d[1] * 10 + d[0];
            res += hash[t];
            hash[t]++;
        }
        return res;
    }

    public static void main(String[] args) {

        int[][] dominoes = {{1, 2}, {2, 1}, {3, 4}, {5, 6}};
        System.out.println((new Solution()).numEquivDominoPairs(dominoes));  // 1
    }
}
