package _1356_Sort_Integers_by_The_Number_of_1_Bits;

import java.util.Arrays;

/**
 * Date: 2020/11/6 10:24
 * Content:
 * https://leetcode-cn.com/problems/sort-integers-by-the-number-of-1-bits/solution/javaliang-ci-xun-huan-da-bai-100-by-yourtion/
 * 执行用时：3 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：38.8 MB, 在所有 Java 提交中击败了85.16%的用户
 * 和Solution2只有唯一一处差别，即是否调用count
 */
public class Solution3 {
    // 因为数组元素在[0, 10000]之间，所以最多14位，10000=0b 10 0111 0001 0000
    public static final int MAX = 10000 * 10;  // 这个数只要大于10000即可，这个数的目的是为了保存二进制表示中数字 1 出现的次数
    public static final int MASK = 0b1;
    public static final int TURNS = 14;

    // 统计数字二进制表示中数字 1 出现的次数
    private int count(int num) {
        int res = 0;
        for (int i = 0; i < TURNS; i++) {
            if ((num & MASK) == 1)
                res++;
            num >>>= 1;  // 无符号右移，忽略符号位，空位都以0补齐
        }

        return res;
    }

    public int[] sortByBits(int[] arr) {
        // 第一步：更新数组中的每个数据
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.bitCount(arr[i]) * MAX + arr[i];  // 调用这句话也行，下面的也行，二选一
//            arr[i] = count(arr[i]) * MAX + arr[i];
        }
        // 第二步：排序
        Arrays.sort(arr);
        // 第三步：还原原始数据
        for (int i = 0; i < arr.length; i++) {
            arr[i] %= MAX;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8};  // [0 1 2 4 8 3 5 6 7]
//        int[] arr = {1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1};  // [1 2 4 8 16 32 64 128 256 512 1024]
//        int[] arr = {10000, 10000};  // [10000 10000]
//        int[] arr = {2, 3, 5, 7, 11, 13, 17, 19};  // [2 3 5 17 7 11 13 19]
//        int[] arr = {10, 100, 1000, 10000};  // [10 100 10000 1000]
        int[] res = (new Solution3()).sortByBits(arr);

        System.out.print("[");
        for (int i = 0; i < res.length; i++) {
            if (i != res.length - 1)
                System.out.print(res[i] + " ");
            else
                System.out.print(res[i]);
        }
        System.out.println("]");
    }
}
