package _0547_Friend_Circles;

/**
 * Date: 2020/9/7 16:37
 * Content:
 * 这是一个图的问题，寻找图的连通分量个数
 * 时间复杂度：O(n^2)，因为整个图都需要遍历
 * 空间复杂度：O(n)，visited数组的大小
 */
class Solution {
    // 从i开始深度优先遍历
    private void dfs(int[][] M, boolean[] visited, int i) {
        visited[i] = true;
        for (int j = 0; j < M.length; j++)
            if (M[i][j] == 1 && !visited[j])
                dfs(M, visited, j);
    }

    public int findCircleNum(int[][] M) {
        if (M.length == 0)
            return 0;

        boolean[] visited = new boolean[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++)
            if (!visited[i]) {
                count++;
                dfs(M, visited, i);
            }
        return count;
    }

    public static void main(String[] args) {
//        int[][] M = {
//                {1, 1, 0},
//                {1, 1, 0},
//                {0, 0, 1}
//        };
        int[][] M = {
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 0, 1, 1}
        };
        System.out.println((new Solution()).findCircleNum(M));
    }
}