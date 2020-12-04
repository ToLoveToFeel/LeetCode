package _0215_Kth_Largest_Element_in_an_Array;

/**
 * 快排中的partion操作
 * 时间复杂度：O(n)
 * 空间复杂度：O(logn)
 */
public class Solution4 {

    public int selectK(int[] nums, int k) {

        return selectK(nums, 0, nums.length - 1, k - 1);
    }

    private int selectK(int[] nums, int l, int r, int k) {

        if (l == r)
            return nums[l];

        int p = partion(nums, l, r);
        if (p == k)
            return nums[p];
        else if (p > k)
            return selectK(nums, l, p - 1, k);
        else
            return selectK(nums, p + 1, r, k);
    }

    // 对nums[l...r]进行partition操作
    // 返回p，使得nums[l...p-1]>=nums[p]，nums[p+1...r]<=p
    private int partion(int[] nums, int l, int r) {

        swap(nums, l, (int) (Math.random() * (r - l + 1) + l));
        int v = nums[l];  // 标定点
        //          arr[l+1...j] > v     arr[j+1...i-1] < v
        // \--\   \--\--\--\--\--\--\   \--\--\--\--\--\--\   \--\--\--\--\--\--\--\--\
        //   l     l+1            j     j+1            i-1     i
        // if(nums[i] > nums[l])   (1) 交换nums[i]和nums[j+1];   (2) j++;   (3)i++;考察下一个元素
        // 最后交换nums[l]和nums[j]
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] > v) {
                swap(nums, j + 1, i);
                j++;
            }
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

        System.out.println((new Solution4()).selectK(nums, k));
    }
}
