package _0922_Sort_Array_By_Parity_II;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Date: 2020/11/12 9:11
 * Content:
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 * <p>
 * 执行用时：2 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：41.5 MB, 在所有 Java 提交中击败了31.33%的用户
 */
public class Solution {

    public int[] sortArrayByParityII(int[] A) {

        int n = A.length;
        assert n >= 2;

        int[] res = new int[n];
        int i = 0, j = 1;  // i 指向偶数位置，j 指向奇数位置
        for (int value : A) {
            if ((value & 1) == 0) {  // 偶数
                res[i] = value;
                i += 2;
            } else {
                res[j] = value;
                j += 2;
            }
        }

        return res;
    }

    public static void main(String[] args) {

        int[] A = {4, 2, 5, 7};
        int[] res = (new Solution()).sortArrayByParityII(A);

        System.out.println(Arrays.stream(res).boxed().collect(Collectors.toList()));
    }
}
