package _0493_Reverse_Pairs;

import java.util.*;

/**
 * Date: 2020/11/28 14:48
 * Content: 树状数组
 * 执行用时：188 ms, 在所有 Java 提交中击败了13.63%的用户
 * 内存消耗：60.4 MB, 在所有 Java 提交中击败了5.09%的用户
 */
public class Solution2 {

    public int reversePairs(int[] nums) {

        // 一.离散化
        /*
         * 1.去重
         * 2.排序
         * 3.利用哈希表进行离散化
         */
        // 1.去重
        Set<Long> set = new TreeSet<>();
        for (int x : nums) {
            set.add((long) x);
            set.add((long) x * 2);
        }
        // 2.排序，TreeSet里面的数据本身就有序

        // 3.利用哈希表进行离散化
        Map<Long, Integer> map = new HashMap<>();
        int index = 1;
        for (long x : set) {
            map.put(x, index);
            index++;
        }

        // 二.利用树状数组求解
        int res = 0;
        Fenwick fenwick = new Fenwick(map.size());
        for (int num : nums) {
            int leftIndex = map.get((long) num * 2);
            int rightIndex = map.size();
            // A[i] : 代表数值为(key, i)中key的个数
            // A[0...rightIndex] - A[0...leftIndex] = A[leftIndex + 1 ... rightIndex]
            int count = fenwick.query(rightIndex) - fenwick.query(leftIndex);
            res += count;

            index = map.get((long) num);
            fenwick.update(index, 1);
        }
        return res;
    }


    public static void main(String[] args) {

        int[] nums = {12, 34, 24, 34, 12};  // 2
//        int[] nums = {-5, -5};  // 0
//        int[] nums = {2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647};
        System.out.println((new Solution2()).reversePairs(nums));
    }
}
/*
 int[] nums = {12, 34, 24, 34, 12};
 Fenwick中的A数组：
    离散化：      A
        12      1
        24      2
        34      3
        48      4
        68      5
    当遍历到nums的最后一个元素12时，A如下
    A   1    2   3   4   5
        1    1   2
    相当于：
    A   12   24  34  48  68
        1    1   2
    12*2=24,大于24的数据的个数有是34，有2个
 */
