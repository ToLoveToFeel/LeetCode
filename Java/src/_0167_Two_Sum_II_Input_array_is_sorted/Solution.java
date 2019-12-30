package _0167_Two_Sum_II_Input_array_is_sorted;

public class Solution {
    // 时间复杂度：O(n^2)
    // 空间复杂度：O(1)
    public int[] twoSum(int[] numbers, int target) {

        int[] ret = new int[2];

        for (int i = 0; i < numbers.length; i++)
            for (int j = i + 1; j < numbers.length; j++){
                if (numbers[i] + numbers[j] == target){
                    ret[0] = i + 1;
                    ret[1] = j + 1;
                }
            }

        return ret;
    }

    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 9;

        int[] res = new int[2];

        res = (new Solution()).twoSum(numbers, target);
        for (int i = 0; i < res.length; i++)
            System.out.println(res[i]);
    }
}