package _0000_study._leetcode._swordoffer._051_reversePairs;

import java.util.*;

/**
 * Date: 2020/11/29 10:47
 * Content: 线段树
 * 执行用时：281 ms, 在所有 Java 提交中击败了5.00%的用户
 * 内存消耗：52.8 MB, 在所有 Java 提交中击败了5.01%的用户
 */
public class Solution3 {

    public int reversePairs(int[] nums) {

        // 一.离散化：去重、排序、离散化
        Set<Integer> set = new TreeSet<>();  // TreeSet里的数据有序
        for (int num : nums) {
            set.add(num);
        }

        Map<Integer, Integer> map = new HashMap<>();  // (num, index)
        int index = 1;
        for (Integer x : set) {
            map.put(x, index);
            index++;
        }

        // 二.利用线段树求解
        int res = 0;
        Integer[] indexArray = new Integer[set.size() + 1];
        Arrays.fill(indexArray, 0);
        SegmentTree<Integer> segmentTree = new SegmentTree<>(indexArray, (a, b) -> a + b);
        for (int num : nums) {
            int leftIndex = map.get(num);
            int rightIndex = map.size();
            if (leftIndex + 1 <= rightIndex) {
                // indexArray[leftIndex + 1, rightIndex]之和
                int count = segmentTree.query(leftIndex + 1, rightIndex);
                res += count;
            }

            // 将 indexArray[leftIndex]更新为 indexArray[leftIndex]+1
            segmentTree.set(leftIndex, segmentTree.get(leftIndex) + 1);
        }

        return res;
    }

    public static void main(String[] args) {

        int[] nums = {7, 5, 6, 4};  // 5
        System.out.println((new Solution3()).reversePairs(nums));
    }
}
