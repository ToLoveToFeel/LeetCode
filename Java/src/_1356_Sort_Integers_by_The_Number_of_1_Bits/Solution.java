package _1356_Sort_Integers_by_The_Number_of_1_Bits;

import java.util.*;

/**
 * Date: 2020/11/6 10:24
 * Content:
 * 执行用时：7 ms, 在所有 Java 提交中击败了54.19%的用户
 * 内存消耗：39.1 MB, 在所有 Java 提交中击败了54.13%的用户
 */
public class Solution {
    // 因为数组元素在[0, 10000]之间，所以最多14位，10000=0b 10 0111 0001 0000
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
        // 第一步：统计各个数字二进制表示中数字 1 出现的次数
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < TURNS; i++)
            map.put(i, new ArrayList<>());

        for (int value : arr) {
            map.get(count(value)).add(value);
        }
        // 第二步：整理之后，对二进制表示中数字 1 出现次数相同的数据进行排序
        int[] res = new int[arr.length];
        int turn = 0;  // 控制循环的轮次
        int index = 0;  // 控制数组的下标
        while (turn < TURNS) {
            List<Integer> list = map.get(turn);
            for (int i = 0; i < list.size(); i++) {
                res[index + i] = list.get(i);
            }
            Arrays.sort(res, index, index + list.size());  // [index, index+list.size())
            index += list.size();

            turn++;
        }

        return res;
    }

    public static void main(String[] args) {
//        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8};  // [0 1 2 4 8 3 5 6 7]
//        int[] arr = {1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1};  // [1 2 4 8 16 32 64 128 256 512 1024]
//        int[] arr = {10000, 10000};  // [10000 10000]
//        int[] arr = {2, 3, 5, 7, 11, 13, 17, 19};  // [2 3 5 17 7 11 13 19]
        int[] arr = {10, 100, 1000, 10000};  // [10 100 10000 1000]
        int[] res = (new Solution()).sortByBits(arr);

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
