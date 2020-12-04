package _0215_Kth_Largest_Element_in_an_Array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(n)
 */
public class Solution2 {

    public int findKthLargest(int[] nums, int k) {

        Integer[] arr = new Integer[nums.length];

        for (int i = 0; i < nums.length; i++)
            arr[i] = nums[i];

        Arrays.sort(arr, (o1, o2) -> {
            // 如果o1小于o2，我们就返回正值，如果o1大于o2我们就返回负值，
            // 这样颠倒一下，就可以实现反向排序了
            return -(o1 - o2);
        });

        return arr[k - 1];
    }

    public static void main(String[] args) {

        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;

        System.out.println((new Solution2()).findKthLargest(nums, k));
    }
}
