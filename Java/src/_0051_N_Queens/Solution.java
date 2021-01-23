package _0051_N_Queens;

import java.util.*;

/**
 * Date: 2020/9/3 10:10
 * Content:
 * 方法：回溯法
 * 时间复杂度：O(n!)
 * 空间复杂度：O(n)
 */
class Solution {

    List<List<String>> res;
    // 为false代表还未被占用
    boolean[] col;
    boolean[] dia1;  // 从右上角到左下角方向的对角线
    boolean[] dia2;  // 从左下角到右上角方向的对角线

    // 尝试在一个n皇后的问题中，摆放第index行的皇后的位置
    // row[i] = j，代表在第i行，第j列有一个皇后
    private void putQueue(int n, int index, LinkedList<Integer> row) {
        if (index == n) {
            res.add(generateBoard(n, row));
            return;
        }

        for (int j = 0; j < n; j++)
            // 尝试将第index行的皇后摆放到第j列
            if (!col[j] && !dia1[index + j] && !dia2[index - j + n - 1]) {
                row.add(j);
                col[j] = dia1[index + j] = dia2[index - j + n - 1] = true;
                putQueue(n, index + 1, row);
                col[j] = dia1[index + j] = dia2[index - j + n - 1] = false;
                row.removeLast();
            }
    }

    // 生成一个n皇后的解
    private List<String> generateBoard(int n, LinkedList<Integer> row) {

        List<String> board = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char[] s = new char[n];
            Arrays.fill(s, '.');
            s[row.get(i)] = 'Q';
            board.add(new String(s));
        }
        return board;
    }

    public List<List<String>> solveNQueens(int n) {

        res = new LinkedList<>();
        col = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];

        LinkedList<Integer> row = new LinkedList<>();
        putQueue(n, 0, row);

        return res;
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<String>> res = (new Solution()).solveNQueens(n);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < n; j++)
                System.out.println(res.get(i).get(j) + " ");
            System.out.println();
        }
        System.out.println(n + "皇后的解的个数：" + res.size());
    }
}
