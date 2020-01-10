package _0279_Perfect_Squares;

import javafx.util.Pair;

import java.util.LinkedList;

public class Solution {
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    public int numSquares(int n) {
        if (0 == n)
            return 0;
        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();  // (数字，n经过的 步数 到达该数字)
        queue.addLast(new Pair<>(n, 0));
        boolean[] visited = new boolean[n+1];
        visited[n] = true;

        while (!queue.isEmpty()){
            Pair<Integer, Integer> front = queue.removeFirst();
            int num = front.getKey();
            int step = front.getValue();

            for (int i = 1; ; i++){
                int a = num - i*i;
                if (a < 0)
                    break;
                if (0 == a)
                    return step + 1;
                if (!visited[a]){
                    queue.addLast(new Pair<>(a, step+1));
                    visited[a] = true;
                }
            }
        }

        throw new IllegalArgumentException("No Solution!");
    }

    public static void main(String[] args) {
        System.out.println((new Solution()).numSquares(12));
        System.out.println((new Solution()).numSquares(13));
    }
}
