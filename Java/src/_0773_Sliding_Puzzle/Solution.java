package _0773_Sliding_Puzzle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    // 时间复杂度：O(n!)
    private int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};  // 某个点的四个方向，上右下左
    public int slidingPuzzle(int[][] board) {

        Queue<String> queue = new LinkedList<>();
        HashMap<String, Integer> visited = new HashMap<>();  // 记录到达 String 需要的步骤，不存在在visited里代表没访问到

        String initialState = boardToString(board);
        if (initialState.equals("123450"))
            return 0;

        queue.add(initialState);
        visited.put(initialState, 0);
        while (!queue.isEmpty()){
            String cur = queue.remove();

            ArrayList<String> nexts = getNexts(cur);

            for (String next : nexts)
                if (!visited.containsKey(next)){
                    queue.add(next);
                    visited.put(next, visited.get(cur) + 1);
                    if (next.equals("123450"))
                        return visited.get(next);
                }
        }
        return -1;
    }

    private ArrayList<String> getNexts(String s){
        ArrayList<String> res = new ArrayList<>();
        int[][] cur = stringToBoard(s);
        int zero;
        for (zero = 0; zero < 6; zero++)
            if (0 == cur[zero / 3][zero % 3])
                break;

        int zx = zero / 3, zy = zero % 3;
        for (int d = 0; d < 4; d++){
            int newX = zx + dirs[d][0], newY = zy + dirs[d][1];
            if (inArea(newX, newY)){
                swap(cur, zx, zy, newX, newY);
                res.add(boardToString(cur));
                swap(cur, zx, zy, newX, newY);
            }
        }

        return res;
    }

    private String boardToString(int[][] board){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 3; j++)
                sb.append(board[i][j]);
        return sb.toString();
    }

    private int[][] stringToBoard(String s){
        int[][] res = new int[2][3];

        for (int i = 0; i < s.length(); i++)
            res[i/3][i%3] = s.charAt(i) - '0';

        return res;
    }

    private boolean inArea(int x, int y){
        return x >= 0 && x < 2 && y >= 0 && y <3;
    }

    private void swap(int[][] board, int x, int y, int newX, int newY){
        int t = board[x][y];
        board[x][y] = board[newX][newY];
        board[newX][newY] = t;
    }

    public static void main(String[] args) {
        int[][] board = {{4,1,2}, {5,0,3}};

        System.out.println((new Solution()).slidingPuzzle(board));
    }

}
