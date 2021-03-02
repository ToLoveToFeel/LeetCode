package _0658_Find_K_Closest_Elements;

import java.util.*;

/**
 * Created by WXX on 2021/3/2 9:43
 * 二分+双指针，时间复杂度：O(log(n) + k)
 * 执行用时：8 ms, 在所有 Java 提交中击败了45.00%的用户
 * 内存消耗：40.5 MB, 在所有 Java 提交中击败了28.88%的用户
 */
public class Solution2 {

    static class MyPair implements Comparable<MyPair> {
        int x, y;

        public MyPair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(MyPair o) {
            if (this.x != o.x) return o.x - this.x;
            else return o.y - this.y;
        }
    }

    public List<Integer> findClosestElements(int[] arr, int k, int T) {

        int l = 0, r = arr.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (arr[mid] >= T) r = mid;
            else l = mid + 1;
        }
        if (r > 0) {
            int x = arr[r - 1], y = arr[r];
            if (new MyPair(Math.abs(x - T), x).compareTo(new MyPair(Math.abs(y - T), y)) > 0) r--;
        }
        int i = r, j = r;
        for (int u = 0; u < k - 1; u++) {
            if (i - 1 < 0) j++;
            else if (j + 1 >= arr.length) i--;
            else {
                int x = arr[i - 1], y = arr[j + 1];
                MyPair a = new MyPair(Math.abs(x - T), x), b = new MyPair(Math.abs(y - T), y);
                if (a.compareTo(b) < 0) j++;
                else i--;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int u = i; u <= j; u++) res.add(arr[u]);
        return res;
    }

    public static void main(String[] args) {

//        int[] arr = {1, 2, 3, 4, 5};
//        System.out.println((new Solution2()).findClosestElements(arr, 4, 3));  // [1, 2, 3, 4]
        int[] arr = {0, 0, 1, 2, 3, 3, 4, 7, 7, 8};
        System.out.println((new Solution2()).findClosestElements(arr, 3, 5));  // [3, 3, 4]
    }
}
