package _0000_study.classicalproblems.knapsack._03_knapsackmulti;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Date: 2020/12/26 16:36
 * Content: 使用单调队列优化多重背包问题
 * https://www.acwing.com/solution/content/6500/   以下代码的 r 对应该网址的 j
 * https://www.acwing.com/solution/content/26583/
 */
public class KnapsackMulti_dp4 {

    // dp[n][C]：考虑将前n个物品(物品编号从0开始)放进容量为C的背包，使得价值最大
    // dp[C]
    public int knapsackMulti(int[] weights, int[] values, int[] nums, int C) {

        int n = weights.length;  // 类别的个数
        int[] pre = new int[C + 1];  // 动态规划中上一行的值
        int[] dp = new int[C + 1];

        for (int i = 0; i < n; i++) {

            System.arraycopy(dp, 0, pre, 0, dp.length);
            int weight = weights[i];  // 重量
            int value = values[i];  // 价值
            int num = nums[i];  // 数量

            // 同余，相当于将容量按照余数划分；余数是：容量k % weight
            for (int r = 0; r < weight; r++) {  // 容量k % weight = r
                // 队列中存储的是对应的容量: r, r+weight, r+2weight, ... 中的某一部分数据
                // 以下问题类似于滑动窗口求最值的问题，可以参考 Leetcode 0239
                Deque<Integer> q = new ArrayDeque<>();
                for (int k = r; k <= C; k += weight) {  // 遍历该组数据，这个for相当于 Leetcode 0239中的 for
                    // 删除过时的数据(因为存在滑动窗口，滑动窗口的大小就是当前物品的数量 num)
                    // 具体可以参考 https://www.acwing.com/solution/content/26583/ 提供的图形
                    if (!q.isEmpty() && k - num * weight > q.getFirst()) q.removeFirst();
                    // 删除价值小于 当前加入元素curValue 的元素
                    // (k - r) / weight : 物品的个数
                    int cur = pre[k] - (k - r) / weight * value;  // 当前窗口中新加入的值
                    while (!q.isEmpty()
                            && pre[q.getLast()] - (q.getLast() - r) / weight * value <= cur)
                        q.removeLast();
                    // 添加当前容量
                    q.addLast(k);
                    // 获取当前窗口内的最大值
                    dp[k] = pre[q.getFirst()] + (k - q.getFirst()) / weight * value;
                }
            }
        }

        return dp[C];
    }

    public static void main(String[] args) {

        int[] weights = {1, 3, 2};  // 每件物品的重量
        int[] values = {4, 7, 6};  // 每件物品的价值
        int[] nums = {2, 2, 3};  // 每类物品的数量
        int weightCapacity = 5;  // 最大能承载的重量
        System.out.println(
                (new KnapsackMulti_dp4()).knapsackMulti(
                        weights,
                        values,
                        nums,
                        weightCapacity
                )
        );
    }
}
