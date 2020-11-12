package _0922_Sort_Array_By_Parity_II;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Date: 2020/11/12 9:11
 * Content:
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 *
 * 执行用时：2 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：40.4 MB, 在所有 Java 提交中击败了48.98%的用户
 */
public class Solution {

    public int[] sortArrayByParityII(int[] A) {

        int n = A.length;
        assert n >= 2;

        int[] even = new int[n / 2];
        int[] odd = new int[n / 2];
        // 第一步：将数据按照奇偶存入不同数组中
        int evenIndex = 0, oddIndex = 0;
        for (int value : A) {
            if ((value & 1) == 0)  // 偶数
                even[evenIndex++] = value;
            else
                odd[oddIndex++] = value;
        }

        // 第二步：收集
        for (int i = 0; i < n / 2; i++) {
            A[2 * i] = even[i];
            A[2 * i + 1] = odd[i];
        }

        return A;
    }

    public static void main(String[] args) {

        int[] A = {4, 2, 5, 7};
        int[] res = (new Solution()).sortArrayByParityII(A);

        System.out.println(Arrays.stream(res).boxed().collect(Collectors.toList()));
    }
}
