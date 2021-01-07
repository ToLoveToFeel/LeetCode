package _0547_Number_of_Provinces;

/**
 * Date: 2021/1/7 9:20
 * Content:
 * 执行用时：3 ms, 在所有 Java 提交中击败了30.46%的用户
 * 内存消耗：39.4 MB, 在所有 Java 提交中击败了53.03%的用户
 */
public class Solution {

    public static int[] p;

    private int find(int x) {
        if (x != p[x]) p[x] = find(p[x]);
        return p[x];
    }

    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;
        p = new int[n];

        for (int i = 0; i < n; i++) p[i] = i;

        int res = n;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++) {
                int p1 = find(i), p2 = find(j);
                if (isConnected[i][j] == 1 && p1 != p2) {
                    p[p1] = p2;
                    res--;
                }
            }

        return res;
    }

    public static void main(String[] args) {
        int[][] isConnected = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
//        int[][] isConnected = {
//                {1, 0, 0, 1},
//                {0, 1, 1, 0},
//                {0, 1, 1, 1},
//                {1, 0, 1, 1}
//        };
        System.out.println((new Solution()).findCircleNum(isConnected));
    }
}
