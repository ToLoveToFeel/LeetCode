package _0149_Max_Points_on_a_Line;

import javafx.util.Pair;

import java.util.HashMap;

public class Solution {
    public int maxPoints(int[][] points) {

        int res = 0;
        for (int[] p : points) {
            int ss = 0, vs = 0;
            HashMap<Double, Integer> cnt = new HashMap<>();
            for (int[] q : points) {
                if (p == q) ss++;
                else if (p[0] == q[0]) vs++;
                else {
                    double k = (double) (q[1] - p[1]) / (q[0] - p[0]);
                    cnt.put(k, cnt.getOrDefault(k, 0) + 1);
                }
            }
            int c = vs;
            for (double k : cnt.keySet()) c = Math.max(c, cnt.get(k));
            res = Math.max(res, c + ss);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] point = {{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
        System.out.println((new Solution()).maxPoints(point));
    }
}
