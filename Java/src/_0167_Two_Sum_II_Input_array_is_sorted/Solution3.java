package _0167_Two_Sum_II_Input_array_is_sorted;

public class Solution3 {
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public int[] twoSum(int[] numbers, int target) {

        int[] ret = new int[2];

        int l = 0, r = numbers.length - 1;
        while (l < r){
            if (numbers[l] + numbers[r] == target){
                ret[0] = l + 1;
                ret[1] = r + 1;
                break;
            }
            else if (numbers[l] + numbers[r] < target)
                l++;
            else
                r--;
        }

        return ret;
    }

    public static void main(String[] args) {
        int[] numbers = {-1, 0};
        int target = -1;

        int[] res = new int[2];

        res = (new Solution3()).twoSum(numbers, target);
        for (int i = 0; i < res.length; i++)
            System.out.println(res[i]);
    }
}
