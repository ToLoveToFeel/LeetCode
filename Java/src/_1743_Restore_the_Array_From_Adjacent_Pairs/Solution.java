package _1743_Restore_the_Array_From_Adjacent_Pairs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Date: 2021/7/25 10:15
 * Content:
 */
public class Solution {

    public int[] restoreArray(int[][] aps) {
        HashMap<Integer, List<Integer>> hash = new HashMap<>();
        for (int[] e : aps) {
            if (!hash.containsKey(e[0])) hash.put(e[0], new ArrayList<>());
            if (!hash.containsKey(e[1])) hash.put(e[1], new ArrayList<>());
            hash.get(e[0]).add(e[1]);
            hash.get(e[1]).add(e[0]);
        }

        int n = aps.length + 1;  // 数组中元素的个数
        int[] res = new int[n];
        for (int k : hash.keySet())
            if (hash.get(k).size() == 1) {
                res[0] = k;
                break;
            }
        res[1] = hash.get(res[0]).get(0);
        for (int i = 2; i < n; i++) {
            // t : res[i - 1] -> {res[i-2], res[i]}
            List<Integer> t = hash.get(res[i - 1]);
            if (res[i - 2] == t.get(0)) res[i] = t.get(1);
            else res[i] = t.get(0);
        }
        return res;
    }

    public static void main(String[] args) {

        int[][] aps = {
                {2, 1},
                {3, 4},
                {3, 2}
        };
        System.out.println(Arrays.toString((new Solution()).restoreArray(aps)));
    }
}
