package _0852_Peak_Index_in_a_Mountain_Array;

/**
 * Date: 2021/6/15 8:43
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：38.6 MB, 在所有 Java 提交中击败了70.15%的用户
 */
public class Solution {

    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int l = 1, r = n - 2;
        while (l < r) {
            int mid = l + r >> 1;
            if (arr[mid] > arr[mid + 1]) r = mid;
            else l = mid + 1;
        }
        return r;
    }

    public static void main(String[] args) {

        int[] arr = {24, 69, 100, 99, 79, 78, 67, 36, 26, 19};
        System.out.println((new Solution()).peakIndexInMountainArray(arr));  // 2
    }
}
