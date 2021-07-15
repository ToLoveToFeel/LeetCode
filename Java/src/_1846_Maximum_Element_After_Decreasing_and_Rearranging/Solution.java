package _1846_Maximum_Element_After_Decreasing_and_Rearranging;

import java.util.Arrays;

/**
 * Date: 2021/7/15 10:00
 * Content:
 */
public class Solution {

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        arr[0] = 1;
        for (int i = 1; i < n; i++)
            if (arr[i] > arr[i - 1] + 1)
                arr[i] = arr[i - 1] + 1;
        return arr[n - 1];
    }

    public static void main(String[] args) {

        int[] arr = {2, 2, 1, 2, 1};
        System.out.println((new Solution()).maximumElementAfterDecrementingAndRearranging(arr));  // 2
    }
}
