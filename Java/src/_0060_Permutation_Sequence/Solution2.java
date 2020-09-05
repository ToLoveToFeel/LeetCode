package _0060_Permutation_Sequence;

import java.util.LinkedList;
import java.util.List;

/**
 * Date: 2020/9/5 10:07
 * Content:
 * https://leetcode-cn.com/problems/permutation-sequence/solution/hui-su-jian-zhi-python-dai-ma-java-dai-ma-by-liwei/
 */
class Solution2 {

    public String getPermutation(int n, int k) {
        k--;  // 注意：相当于在 n 个数字的全排列中找到下标为 k - 1 的那个数，因此 k 先减 1

        int[] factorial = new int[n];  // factorial[i] = i!
        factorial[0] = 1;
        for (int i = 1; i < n; i++)
            factorial[i] = factorial[i - 1] * i;

        List<Integer> nums = new LinkedList<>();
        for (int i = 1; i <= n; i++)
            nums.add(i);

        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            int index = k / factorial[i];
            sb.append(nums.remove(index));
            k -= index * factorial[i];
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println((new Solution2()).getPermutation(3, 5));
        System.out.println((new Solution2()).getPermutation(4, 12));
    }
}