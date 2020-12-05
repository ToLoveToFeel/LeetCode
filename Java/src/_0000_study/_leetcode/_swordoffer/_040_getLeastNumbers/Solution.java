package _0000_study._leetcode._swordoffer._040_getLeastNumbers;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * Date: 2020/12/5 15:29
 * Content: 使用优先队列解决
 * <p>
 * 执行用时：24 ms, 在所有 Java 提交中击败了17.26%的用户
 * 内存消耗：39.9 MB, 在所有 Java 提交中击败了60.59%的用户
 */
public class Solution {

    public int[] getLeastNumbers(int[] arr, int k) {

        if (k <= 0)
            return new int[]{};

        // 第一步：使用优先队列得到结果
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> -(o1 - o2));  // 大顶堆
        for (int num : arr) {
            if (queue.size() < k) {
                queue.add(num);
            } else if (queue.peek() > num) {
                queue.remove();
                queue.add(num);
            }
        }

        // 第二步：整理并返回
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.remove();
        }

        return res;
    }

    public static void main(String[] args) {

//        // [2, 1]
//        int[] arr = {3, 2, 1};
//        int k = 2;
        // [0]
        int[] arr = {0, 1, 2, 1};
        int k = 1;
        int[] res = (new Solution()).getLeastNumbers(arr, k);

        System.out.println(Arrays.stream(res).boxed().collect(Collectors.toList()));
    }
}
