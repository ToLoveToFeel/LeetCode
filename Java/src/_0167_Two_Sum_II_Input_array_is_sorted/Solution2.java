package _0167_Two_Sum_II_Input_array_is_sorted;

public class Solution2 {
    // 时间复杂度：O(n*log(n))
    // 空间复杂度：O(1)
    public int[] twoSum(int[] numbers, int target) {

        int[] ret = new int[2];

        for (int i = 0; i < numbers.length - 1; i++){
            int temp = binarySearch(numbers, i + 1, numbers.length - 1, target - numbers[i]);
            if (-1 != temp){
                ret[0] = i + 1;
                ret[1] = temp + 1;
            }
        }

        return ret;
    }

    // 在arr[l...r]中寻找target，并返回target所在下标
    private int binarySearch(int[] arr, int l, int r, int target){

        while (l <= r){
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

        int[] res = new int[2];

        res = (new Solution2()).twoSum(numbers, target);
        for (int i = 0; i < res.length; i++)
            System.out.println(res[i]);
    }
}

