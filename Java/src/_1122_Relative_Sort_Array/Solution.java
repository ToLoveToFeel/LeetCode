package _1122_Relative_Sort_Array;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Date: 2020/11/14 14:53
 * Content:
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：38.6 MB, 在所有 Java 提交中击败了46.46%的用户
 */
public class Solution {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        if (arr1.length <= 1)
            return arr1;

        // 第一步，使用哈希表记录arr1中数据出现的次数
        int[] count = new int[1001];
        for (int num : arr1) {
            count[num]++;
        }

        // 第二步：整理数据得到结果，存入arr1中
        int index = 0;
        for (int num : arr2) {
            for (int i = 0; i < count[num]; i++) {
                arr1[index++] = num;
            }
            count[num] = 0;
        }
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {  // 如果count[i]不为0，说明数据i只在arr1中，未出现在arr2中
                arr1[index++] = i;
            }
        }

        return arr1;
    }

    public static void main(String[] args) {

        // 结果：[2, 2, 2, 1, 4, 3, 3, 9, 6, 7, 19]
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};

        int[] res = (new Solution()).relativeSortArray(arr1, arr2);
        System.out.println(Arrays.stream(res).boxed().collect(Collectors.toList()));
    }
}
