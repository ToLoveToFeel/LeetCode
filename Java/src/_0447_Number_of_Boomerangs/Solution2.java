package _0447_Number_of_Boomerangs;

import java.util.HashMap;

public class Solution2 {
    // 时间复杂度：O(n^2)
    // 空间复杂度：O(n)
    public int numberOfBoomerangs(int[][] points) {

        int res = 0;

        for (int i = 0; i < points.length; i++) {
            HashMap<Integer, Integer> record = new HashMap<>();

            for (int j = 0; j < points.length; j++)
                if (i != j) {
                    int distance = dis(points[i], points[j]);
                    if (!record.containsKey(distance))
                        record.put(distance, 1);
                    else
                        record.put(distance, record.get(distance) + 1);
                }

            for (Integer dis : record.keySet())
                res += record.get(dis) * (record.get(dis) - 1);
        }

        return res;
    }

    private int dis(int[] pa, int[] pb){
        return (pa[0] - pb[0]) * (pa[0] - pb[0]) + (pa[1] - pb[1]) * (pa[1] - pb[1]);
    }

    public static void main(String[] args) {
        int[][] points = {{0, 0}, {1, 0}, {2, 0}};

        System.out.println((new Solution2()).numberOfBoomerangs(points));
    }
}
