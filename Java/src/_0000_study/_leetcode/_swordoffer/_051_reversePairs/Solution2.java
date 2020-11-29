package _0000_study._leetcode._swordoffer._051_reversePairs;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Date: 2020/11/29 10:25
 * Content: 树状数组
 * 执行用时：92 ms, 在所有 Java 提交中击败了5.00%的用户
 * 内存消耗：53 MB, 在所有 Java 提交中击败了5.01%的用户
 */
public class Solution2 {

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

        // 二.利用树状数组求解
        int res = 0;
        Fenwick fenwick = new Fenwick(map.size());
        for (int num : nums) {
            int leftIndex = map.get(num);
            int rightIndex = map.size();
            // A[i] : 代表数值为(key, i)中key的个数
            // A[0...rightIndex] - A[0...leftIndex] = A[leftIndex + 1 ... rightIndex]
            int count = fenwick.query(rightIndex) - fenwick.query(leftIndex);
            res += count;

            fenwick.update(leftIndex, 1);
        }

        return res;
    }

    public static void main(String[] args) {

        int[] nums = {7, 5, 6, 4};  // 5
        System.out.println((new Solution2()).reversePairs(nums));
    }
}
