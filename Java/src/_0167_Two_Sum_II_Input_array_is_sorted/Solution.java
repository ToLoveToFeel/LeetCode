package _0167_Two_Sum_II_Input_array_is_sorted;

/**
 * 暴力解法
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 */
public class Solution {

    public int[] twoSum(int[] numbers, int target) {

        int[] res = new int[2];

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    res[0] = i + 1;
                    res[1] = j + 1;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {

        int[] numbers = {2, 7, 11, 15};
        int target = 9;

        int[] res =  (new Solution()).twoSum(numbers, target);
        for (int num : res)
            System.out.println(num);
    }
}