package _1074_Number_of_Submatrices_That_Sum_to_Target;

import java.util.HashMap;

/**
 * Date: 2021/5/29 14:57
 */
public class Solution {

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int res = 0;
        for (int i = 0; i < n; i++) {  // 枚举上边界
            int[] nums = new int[m];
            for (int j = i; j < n; j++) {  // 枚举下边界
                for (int k = 0; k < m; k++)
                    nums[k] += matrix[j][k];
                res += subarraySum(nums, target);
            }
        }
        return res;
    }

    private int subarraySum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> hash = new HashMap<>();
        hash.put(0, 1);
        int s = 0, res = 0;  // s: 前缀和
        for (int i = 1; i <= n; i++) {
            s += nums[i - 1];
            res += hash.getOrDefault(s - target, 0);
            hash.put(s, hash.getOrDefault(s, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {0, 1, 0},
                {1, 1, 1},
                {0, 1, 0},
        };
        System.out.println((new Solution()).numSubmatrixSumTarget(matrix, 0));  // 4
    }
}
