package _0493_Reverse_Pairs;

import java.util.*;

/**
 * Date: 2020/11/28 14:48
 * Content: 线段树
 * <p>
 * 执行用时：363 ms, 在所有 Java 提交中击败了5.18%的用户
 * 内存消耗：57.7 MB, 在所有 Java 提交中击败了5.09%的用户
 */
public class Solution3 {

    public int reversePairs(int[] nums) {

        // 一.离散化：去重、去重、离散化
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
        Integer[] indexArray = new Integer[set.size() + 1];
        Arrays.fill(indexArray, 0);
        SegmentTree<Integer> segmentTree = new SegmentTree<>(indexArray, (a, b) -> a + b);
        for (int num : nums) {
            int leftIndex = map.get((long) num * 2);
            int rightIndex = map.size();
            if (leftIndex + 1 <= rightIndex) {
                // indexArray[leftIndex + 1, rightIndex]之和
                int count = segmentTree.query(leftIndex + 1, rightIndex);
                res += count;
            }

            // 将 indexArray[index]更新为 indexArray[index]+1
            index = map.get((long) num);
            segmentTree.set(index, segmentTree.get(index) + 1);
        }

        return res;
    }


    public static void main(String[] args) {

        int[] nums = {12, 34, 24, 34, 12};  // 2
//        int[] nums = {-5, -5};  // 0
//        int[] nums = {2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647};
        System.out.println((new Solution3()).reversePairs(nums));
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
