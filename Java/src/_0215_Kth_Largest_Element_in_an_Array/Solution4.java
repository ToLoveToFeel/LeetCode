package _0215_Kth_Largest_Element_in_an_Array;

public class Solution4 {
    // 快排中的partion操作
    // 时间复杂度：O(n)
    // 空间复杂度：O(logn)
    public int findKthLargest(int[] nums, int k){
        return findKthLargest(nums, 0, nums.length - 1, k - 1);
    }

    private int findKthLargest(int[] nums, int l, int r, int k){
        if (l == r)
            return nums[l];

        int p = partion(nums, l, r);
        if (p == k)
            return nums[p];
        else if (p > k)
            return findKthLargest(nums, l, p-1, k);
        else
            return findKthLargest(nums, p+1, r, k);
    }

    private int partion(int[] nums, int l, int r){
        swap(nums, l, (int)(Math.random() * (r - l + 1) + l));
        int v = nums[l];  // 标定点
        // arr[i+1...j] > v    arr[j+1...i-1] < v
        int j = l;
        for (int i = l+1; i <= r; i++)
            if (nums[i] > v){
                swap(nums, j+1, i);
                j++;
            }
        swap(nums, l, j);
        return j;
    }

    private void swap(int[] nums, int i, int j){
        int item = nums[i];
        nums[i] = nums[j];
        nums[j] = item;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;

        System.out.println((new Solution4()).findKthLargest(nums, k));
    }
}
