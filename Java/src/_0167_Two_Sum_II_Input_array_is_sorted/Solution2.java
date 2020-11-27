package _0167_Two_Sum_II_Input_array_is_sorted;

/**
 * 二分搜索
 * 时间复杂度：O(n*log(n))
 * 空间复杂度：O(1)
 */
public class Solution2 {

    public int[] twoSum(int[] numbers, int target) {

        int[] res = new int[2];

        for (int i = 0; i < numbers.length - 1; i++) {
            int t = binarySearch(numbers, i + 1, numbers.length - 1, target - numbers[i]);
            if (t != -1) {
                res[0] = i + 1;
                res[1] = t + 1;
            }
        }

        return res;
    }

    // 在arr[l...r]中寻找target，并返回target所在下标
    private int binarySearch(int[] arr, int l, int r, int target) {

        while (l <= r) {

            int mid = l + (r - l) / 2;
            if (arr[mid] == target)
                return mid;
            else if (target > arr[mid])
                l = mid + 1;
            else
                r = mid - 1;
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] numbers = {-1, 0};
        int target = -1;

        int[] res = (new Solution2()).twoSum(numbers, target);
        for (int num : res)
            System.out.println(num);
    }
}

