package _0149_Max_Points_on_a_Line;

import javafx.util.Pair;

import java.util.HashMap;

public class Solution {
    // 未解决
    public int maxPoints(int[][] points) {
        if (points.length <= 1)
            return points.length;

        int res = 1;

        for (int i = 0; i < points.length; i++){
            // 针对每个点i，考虑其余所有点和点i的斜率，斜率相同的点在一条直线上
            // <K,V>：<斜率，点数目>
            HashMap<Pair<Integer, Integer>, Integer> hashMap = new HashMap<>();
            // 考虑和点i重复的点
            int samePoint = 0;
            for (int j = 0; j < points.length; j++) {
                if (points[j][0] == points[i][0] && points[j][1] == points[i][1])
                    samePoint++;
                else {
                    Pair<Integer, Integer> pair = slope(points[j], points[i]);
                    if (!hashMap.containsKey(pair))
                        hashMap.put(pair, 1);
                    else
                        hashMap.put(pair, hashMap.get(pair) + 1);
                }
            }
            if (i == 61){
                for (int j = 0; j < points.length; j++){
                    if (points[j][0] == points[i][0] && points[j][1] == points[i][1])
                        samePoint++;
                    else {
                        Pair<Integer, Integer> pair = slope(points[j], points[i]);
                        if (pair.getKey() == 4 && pair.getValue() == 1)
                            System.out.println("(" + points[j][0] + ", " + points[j][1] + ")");
                    }
                }
            }
            res = Math.max(res, samePoint);  // 考虑情况：所有的点都是同一个位置
            for (Pair<Integer, Integer> pair:hashMap.keySet())
                res = Math.max(res, hashMap.get(pair) + samePoint);
        }

        return res;
    }

    // 求pa和pb之间的斜率
    private Pair<Integer, Integer> slope(int[] pa, int[] pb){
        int dy = pa[1] - pb[1];
        int dx = pa[0] - pb[0];

        if (0 == dx)
            return new Pair<>(1, 0);
        if (0 == dy)
            return new Pair<>(0, 1);

        int  g = gcd(Math.abs(dy), Math.abs(dx));
        dy /= g;
        dx /= g;

        if (dx < 0){
            dy = -dy;
            dx = -dx;
        }

        return new Pair<>(dy, dx);
    }

    // 求a和b的最大公约数
    private static int gcd(int a, int b){
        if (a < b){
            int t = a;
            a = b;
            b = t;
        }

        if (a % b == 0)
            return b;

        return gcd(a, a%b);
    }

    public static void main(String[] args) {
//        int[][] point = {{1,1}, {3,2}, {5,3}, {4,1}, {2,3}, {1,4}};
        int[][] point = {{40,-23},{9,138},{429,115},{50,-17},{-3,80},{-10,33},{5,-21},{-3,80},{-6,-65},
                {-18,26},{-6,-65},{5,72},{0,77},{-9,86},{10,-2},{-8,85},{21,130},{18,-6},{-18,26},{-1,-15},
                {10,-2},{8,69},{-4,63},{0,3},{-4,40},{-7,84},{-8,7},{30,154},{16,-5},{6,90},{18,-6},{5,77},
                {-4,77},{7,-13},{-1,-45},{16,-5},{-9,86},{-16,11},{-7,84},{1,76},{3,77},{10,67},{1,-37},
                {-10,-81},{4,-11},{-20,13},{-10,77},{6,-17},{-27,2},{-10,-81},{10,-1},{-9,1},{-8,43},{2,2},
                {2,-21},{3,82},{8,-1},{10,-1},{-9,1},{-12,42},{16,-5},{-5,-61},{20,-7},{9,-35},{10,6},{12,106},
                {5,-21},{-5,82},{6,71},{-15,34},{-10,87},{-14,-12},{12,106},{-5,82},{-46,-45},{-4,63},{16,-5},
                {4,1},{-3,-53},{0,-17},{9,98},{-18,26},{-9,86},{2,77},{-2,-49},{1,76},{-3,-38},{-8,7},{-17,-37},
                {5,72},{10,-37},{-4,-57},{-3,-53},{3,74},{-3,-11},{-8,7},{1,88},{-12,42},{1,-37},{2,77},{-6,77},
                {5,72},{-4,-57},{-18,-33},{-12,42},{-9,86},{2,77},{-8,77},{-3,77},{9,-42},{16,41},{-29,-37},{0,-41},
                {-21,18},{-27,-34},{0,77},{3,74},{-7,-69},{-21,18},{27,146},{-20,13},{21,130},{-6,-65},{14,-4},{0,3},
                {9,-5},{6,-29},{-2,73},{-1,-15},{1,76},{-4,77},{6,-29}};
        System.out.println((new Solution()).maxPoints(point));
    }
}
