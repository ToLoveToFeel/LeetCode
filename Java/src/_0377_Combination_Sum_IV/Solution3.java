package _0377_Combination_Sum_IV;

/**
 * Date: 2020/9/9 11:52
 * Content: 类似于完全背包问题，但不一样
 * 动态规划
 * https://leetcode-cn.com/problems/combination-sum-iv/solution/xi-wang-yong-yi-chong-gui-lu-gao-ding-bei-bao-wen-/
 * 这个网址关于背包问题总结的很好
 * <p>
 * 本题和 Leetcode 0039基本上一样，
 * 0039 需要求解出具体结果(顺序不同的序列被视作相同的组合)
 * 0377 需要求解出结果个数(顺序不同的序列被视作不同的组合)
 * 如果本题改变一个条件：顺序不同的序列被视作相同的组合(和0039一样)。则该种解法不行!!!
 */
public class Solution3 {
    /**
     * 这里状态定义就是题目要求的，并不难：
     * dp[i]：和为 i 的组合的个数。如果i=0，则dp[0]=1，代表和为0有一种拼凑方式，即一个都不选
     * 例如：nums=[1,3,7], target=7
     * dp[7] = dp[6] + dp[4] + dp[0], 其中dp[0]也代表一种方式，因此dp[0]=1
     * <p>
     * 状态转移方程要动点脑子，也不难：
     * 状态转移方程：dp[i]= dp[i - nums[0]] + dp[i - nums[1]] + dp[i - nums[2]] + ... （当 [] 里面的数 >= 0）
     * 特别注意：dp[0] = 1，表示，如果那个硬币的面值刚刚好等于需要凑出的价值，这个就成为 1 种组合方案
     * 再举一个具体的例子：nums=[1, 3, 4], target=7;
     * dp[7] = dp[6] + dp[4] + dp[3]
     * 即：7 的组合数可以由三部分组成，1 和 dp[6]，3 和 dp[4], 4 和dp[3];
     * <p>
     * 不能使用二维矩阵，这是由于状态转移方程所决定的，需要将每次结果进行累加
     * 不同于背包问题，外层循环是对c进行遍历的，内层循环是对n遍历，因为每次都要对dp[c]进行多次累加计算
     */
    public int combinationSum4(int[] nums, int target) {

        int n = nums.length;  // 物品类别的数
        if (n == 0) return 0;

        int C = target;  // 容量
        int[] dp = new int[C + 1];
        dp[0] = 1;

        for (int i = 1; i <= C; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= nums[j])
                    dp[i] += dp[i - nums[j]];  // 减去nums[j]就代表可以在排列中加入nums[j]
            }
        }

        return dp[C];
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        int target = 4;
        System.out.println((new Solution3()).combinationSum4(nums, target));
    }
}

/*
对于例子
    int[] nums = {1, 2, 3};
    int target = 4;
            0   1   2   3   4   i       C
    0(1)    1   1   1   2   4
    1(2)    1   1   2   3   6
    2(3)    1   1   2   4   7
    j(num)

     n

在 j = 2 的情况下：
    dp[1] : (1)
    dp[2] : (1, 1)          dp[2] = dp[1]{(1,1)} + dp[0]{(2)}
            (2)
    dp[3] : (1, 1, 1)       dp[3] = dp[2]{(1,1,1),(2,1)} + dp[1]{(1,2)} + dp[0]{(3)}
            (2, 1)
            (1, 2)
            (3)
    dp[4] : (1, 1, 1, 1)    dp[4] = dp[3]{(1,1,1,1),(2,1,1),(1, 2, 1),(3, 1)} + dp[2]{(1,1,2),(2,2)} + dp[1]{(1,3)}
            (2, 1, 1)
            (1, 2, 1)
            (3, 1)
            (1, 1, 2)
            (2, 2)
            (1, 3)
 */
