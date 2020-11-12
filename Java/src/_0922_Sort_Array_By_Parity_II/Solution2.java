package _0922_Sort_Array_By_Parity_II;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Date: 2020/11/12 9:11
 * Content: 双指针
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 *
 * 执行用时：2 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：39.4 MB, 在所有 Java 提交中击败了96.48%的用户
 */
public class Solution2 {

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int[] sortArrayByParityII(int[] A) {

        int n = A.length;
        assert n >= 2;

        int j = 1;
        for (int i = 0; i < n; i += 2) {
            if ((A[i] & 1) == 1) {  // 偶数位置出现了奇数
                while ((A[j] & 1) == 1) {  // 寻找第一个奇数位置出现偶数的元素的下标
                    j += 2;
                }
                swap(A, i, j);
            }
        }

        return A;
    }

    public static void main(String[] args) {

        int[] A = {4, 2, 5, 7};
        int[] res = (new Solution2()).sortArrayByParityII(A);

        System.out.println(Arrays.stream(res).boxed().collect(Collectors.toList()));
    }
}
