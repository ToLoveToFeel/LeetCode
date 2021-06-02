package _0436_Find_Right_Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Date: 2021/6/2 9:48
 */
public class Solution {

    public int[] findRightInterval(int[][] interval) {
        int n = interval.length;
        List<int[]> q = new ArrayList<>();
        for (int i = 0; i < n; i++) q.add(new int[]{interval[i][0], interval[i][1], i});
        q.sort((a, b) -> a[0] - b[0]);  // Collections.sort(q, (a, b) -> a[0] - b[0]);
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for (int[] x : q) {
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = l + r >> 1;
                if (q.get(mid)[0] >= x[1]) r = mid;
                else l = mid + 1;
            }
            if (q.get(r)[0] >= x[1]) res[x[2]] = q.get(r)[2];
        }
        return res;
    }

    public static void main(String[] args) {

        int[][] interval = {
                {3, 4},
                {2, 3},
                {1, 2},
        };
        System.out.println(Arrays.toString((new Solution()).findRightInterval(interval)));  // [-1, 0, 1]
    }
}
