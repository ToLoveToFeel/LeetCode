package _0621_Task_Scheduler;

/**
 * Date: 2020/12/5 14:26
 * Content: https://leetcode-cn.com/problems/task-scheduler/solution/jian-ming-yi-dong-de-javajie-da-by-lan-s-jfl9/
 * 时间复杂度：O(tasks.length)
 * 执行用时：2 ms, 在所有 Java 提交中击败了97.81%的用户
 * 内存消耗：40.1 MB, 在所有 Java 提交中击败了29.36%的用户
 */
public class Solution {

    public int leastInterval(char[] tasks, int n) {

        // 第一步：计数排序(都是大写字母)
        int[] cnt = new int[26];
        for (char c : tasks) cnt[c - 'A']++;
        // 第二步：计算出现次数最大值，以及有多少个任务和出现最多的那个任务出现次数一样
        int maxTimes = 0;  // 记录出现次数最多的那个任务
        int maxCount = 0;  // 一共有多少个任务和出现最多的那个任务出现次数一样
        for (int i = 0; i < 26; i++) maxTimes = Math.max(maxTimes, cnt[i]);
        for (int i = 0; i < 26; i++)
            if (cnt[i] == maxTimes)
                maxCount++;

        return Math.max(tasks.length, (maxTimes - 1) * (n + 1) + maxCount);
    }

    public static void main(String[] args) {

//        // 8
//        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
//        int n = 2;
//        // 6
//        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
//        int n = 0;
        // 16
        char[] tasks = {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int n = 2;
        System.out.println((new Solution()).leastInterval(tasks, n));

    }
}
