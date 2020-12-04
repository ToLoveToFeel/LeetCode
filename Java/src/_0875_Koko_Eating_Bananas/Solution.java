package _0875_Koko_Eating_Bananas;

import java.util.Arrays;

/**
 * Date: 2020/12/4 11:33
 * Content:
 * 执行用时：21 ms, 在所有 Java 提交中击败了37.11%的用户
 * 内存消耗：39.8 MB, 在所有 Java 提交中击败了40.67%的用户
 */
public class Solution {

    private int eatingTime(int[] piles, int k) {

        int res = 0;
        for (int pile : piles) {
            res += pile / k + (pile % k > 0 ? 1 : 0);
        }
        return res;
    }

    public int minEatingSpeed(int[] piles, int H) {

        int l = 1, r = Arrays.stream(piles).max().getAsInt();  // 最少每小时吃1根，最多数组中的最大值根
        while (l < r) {  // 因为：piles.length <= H，所以一定有解

            int mid = l + (r - l) / 2;
            if (eatingTime(piles, mid) <= H)
                r = mid;  // 查看吃香蕉的速度能否更慢
            else
                l = mid + 1;  // 需要加快吃香蕉的速度
        }
        return l;
    }

    public static void main(String[] args) {

//        // 4
//        int[] piles = {3, 6, 7, 11};
//        int H = 8;
//        // 30
//        int[] piles = {30, 11, 23, 4, 20};
//        int H = 5;
//        // 23
//        int[] piles = {30, 11, 23, 4, 20};
//        int H = 6;
        // 23
        int[] piles = {312884470};
        int H = 968709470;
        System.out.println((new Solution()).minEatingSpeed(piles, H));
    }
}
