package _0167_Two_Sum_II_Input_array_is_sorted;

/**
 * 双指针
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class Solution3 {

    public int[] twoSum(int[] numbers, int target) {

        int[] res = new int[2];

        int l = 0, r = numbers.length - 1;  // 对撞指针
        while (l < r) {
            if (numbers[l] + numbers[r] == target) {
                res[0] = l + 1;
                res[1] = r + 1;
                break;
            } else if (numbers[l] + numbers[r] < target)
                l++;
            else
                r--;
        }

        return res;
    }

    public static void main(String[] args) {

        int[] numbers = {-1, 0};
        int target = -1;

        int[] res = (new Solution3()).twoSum(numbers, target);
        for (int num : res)
            System.out.println(num);
    }
}
