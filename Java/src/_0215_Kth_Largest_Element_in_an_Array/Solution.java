package _0215_Kth_Largest_Element_in_an_Array;

public class Solution {
    // 超时
    public int findKthLargest(int[] nums, int k) {
        k = k - 1;
        int p = -1;
        int l = 0;
        int r = nums.length - 1;
        while (k != p) {
            p = partition(nums, l, r);
            if (p > k)
                r = p;
            else
                l = p;
        }
        return nums[p];
    }

    // 对nums[l...r]进行partition操作
    // 返回p，使得nums[l...p-1]>=nums[p]，nums[p+1...r]<=p
    private int partition(int[] nums, int l, int r) {
        swap(nums, l, (int) (Math.random() * (r - l + 1) + l));
        int v = nums[l];
        int j = l;
        for (int i = l + 1; i <= r; i++)
            if (nums[i] > v) {
                swap(nums, j + 1, i);
                j++;
            }
        swap(nums, l, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int item = nums[i];
        nums[i] = nums[j];
        nums[j] = item;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;

        System.out.println((new Solution()).findKthLargest(nums, k));
    }
}
