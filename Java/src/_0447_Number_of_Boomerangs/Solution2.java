package _0447_Number_of_Boomerangs;

import java.util.HashMap;

public class Solution2 {

    public int numberOfBoomerangs(int[][] p) {

        int res = 0;
        for (int i = 0; i < p.length; i++) {
            HashMap<Integer, Integer> hash = new HashMap<>();
            for (int j = 0; j < p.length; j++)
                if (i != j) {
                    int dx = p[i][0] - p[j][0], dy = p[i][1] - p[j][1];
                    int d = dx * dx + dy * dy;
                    hash.put(d, hash.getOrDefault(d, 0) + 1);
                }
            for (int dis : hash.keySet()) res += hash.get(dis) * (hash.get(dis) - 1);
        }
        return res;
    }

    public static void main(String[] args) {

        int[][] points = {{0, 0}, {1, 0}, {2, 0}};
        System.out.println((new Solution2()).numberOfBoomerangs(points));
    }
}
