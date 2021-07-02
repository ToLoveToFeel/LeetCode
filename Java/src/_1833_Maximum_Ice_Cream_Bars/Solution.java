package _1833_Maximum_Ice_Cream_Bars;

import java.util.Arrays;

/**
 * Date: 2021/7/2 9:44
 */
public class Solution {

    public int maxIceCream(int[] costs, int coins) {
        int n = costs.length;
        Arrays.sort(costs);
        int cnt = 0;
        while (cnt < n && costs[cnt] <= coins) coins -= costs[cnt++];
        return cnt;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).maxIceCream(new int[]{1, 3, 2, 4, 1}, 7));  // 4
    }
}
