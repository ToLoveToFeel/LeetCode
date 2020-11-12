package _0905_Sort_Array_By_Parity;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Date: 2020/11/12 9:35
 * Content:
 * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：39.1 MB, 在所有 Java 提交中击败了94.93%的用户
 */
public class Solution {

    public int[] sortArrayByParity(int[] A) {

        int n = A.length;
        if (n <= 1)
            return A;

        int[] res = new int[A.length];
        int begin = 0, end = n - 1;
        for (int value : A) {
            if ((value & 1) == 0)  // 偶数放在前面
                res[begin++] = value;
            else
                res[end--] = value;
        }

        return res;
    }

    public static void main(String[] args) {

//        int[] A = {4, 2, 5, 7};
//        int[] A = {4, 5, 7, 2};
//        int[] A = {7, 2};
        int[] A = {3, 1, 2, 4};
        int[] res = (new Solution()).sortArrayByParity(A);

        System.out.println(Arrays.stream(res).boxed().collect(Collectors.toList()));
    }
}
