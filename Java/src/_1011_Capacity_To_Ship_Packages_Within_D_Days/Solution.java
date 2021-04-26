package _1011_Capacity_To_Ship_Packages_Within_D_Days;

import java.util.Arrays;

/**
 * Date: 2020/12/4 11:57
 * Content:
 * 执行用时：17 ms, 在所有 Java 提交中击败了16.15%的用户
 * 内存消耗：41.9 MB, 在所有 Java 提交中击败了85.57%的用户
 */
public class Solution {

    // k -> days(k) : 是一个减函数
    // 如果船舶最低载重为k, 需要运输的天数
    private int days(int[] w, int k) {

        int res = 0;
        int i = 0, t = k;
        while (i < w.length) {
            while (i < w.length && t >= w[i]) t -= w[i++];
            res++;
            t = k;
        }
        return res;
    }

    public int shipWithinDays(int[] weights, int D) {

        int l = 0, r = 0;
        for (int w : weights) {
            l = Math.max(l, w);
            r += w;
        }
        while (l < r) {
            int mid = l + r >> 1;
            if (days(weights, mid) <= D) r = mid;
            else l = mid + 1;
        }
        return r;
    }

    public static void main(String[] args) {

//        // 15
//        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        int D = 5;
//        // 6
//        int[] weights = {3, 2, 2, 4, 1, 4};
//        int D = 3;
        // 3
        int[] weights = {1, 2, 3, 1, 1};
        int D = 4;
        System.out.println((new Solution()).shipWithinDays(weights, D));
    }
}
