package _0060_Permutation_Sequence;

import java.util.LinkedList;
import java.util.List;

/**
 * Date: 2020/9/5 10:07
 * Content:
 * https://leetcode-cn.com/problems/permutation-sequence/solution/hui-su-jian-zhi-python-dai-ma-java-dai-ma-by-liwei/
 */
class Solution2 {
    /**
     直接用回溯法做的话需要在回溯到第k个排列时终止就不会超时了, 但是效率依旧感人
     可以用数学的方法来解, 因为数字都是从1开始的连续自然数, 排列出现的次序可以推
     算出来, 对于 n=4, k=15 找到 k=15 排列的过程:

     1 + 对2,3,4的全排列 (3!个)
     2 + 对1,3,4的全排列 (3!个)         3, 1 + 对2,4的全排列(2!个)
     3 + 对1,2,4的全排列 (3!个)-------> 3, 2 + 对1,4的全排列(2!个)-------> 3, 2, 1 + 对4的全排列(1!个)-------> 3214
     4 + 对1,2,3的全排列 (3!个)         3, 4 + 对1,2的全排列(2!个)         3, 2, 4 + 对1的全排列(1!个)

     确定第一位:
         k = 14(从0开始计数)
         index = k / (n-1)! = 2, 说明第15个数的第一位是3
         更新k
         k = k - index*(n-1)! = 2
     确定第二位:
         k = 2
         index = k / (n-2)! = 1, 说明第15个数的第二位是2
         更新k
         k = k - index*(n-2)! = 0
     确定第三位:
         k = 0
         index = k / (n-3)! = 0, 说明第15个数的第三位是1
         更新k
         k = k - index*(n-3)! = 0
     确定第四位:
         k = 0
         index = k / (n-4)! = 0, 说明第15个数的第四位是4
         最终确定n=4时第15个数为3214
     **/

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