package _0905_Sort_Array_By_Parity;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Date: 2020/11/12 9:35
 * Content: 双指针
 * 执行用时：13 ms, 在所有 Java 提交中击败了5.28%的用户
 * 内存消耗：39.5 MB, 在所有 Java 提交中击败了66.32%的用户
 */
public class Solution2 {

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int[] sortArrayByParity(int[] A) {

        int n = A.length;
        if (n <= 1)
            return A;

        for (int i = 0; i < n; i++) {  // i记录偶数出现的下标
            if ((A[i] & 1) == 1) {  // 说明前面出现了奇数
                int j = i + 1;  // j记录奇数出现的下标
                while (j < n && (A[j] & 1) == 1) {  // 找到未处理数据中第一个偶数出现的位置
                    j++;
                }
                if (j == n)  // 说明处理完毕
                    break;
                else
                    swap(A, i, j);
            }
        }

        return A;
    }

    public static void main(String[] args) {

//        int[] A = {4, 2, 5, 7};
//        int[] A = {4, 5, 7, 2};
//        int[] A = {7, 2};
        int[] A = {3, 1, 2, 4};
        int[] res = (new Solution2()).sortArrayByParity(A);

        System.out.println(Arrays.stream(res).boxed().collect(Collectors.toList()));
    }
}
