# coding=utf-8
# @Time       : 2020/3/10
# @Author     : Wang Xiaoxiao
# @University : Dalian University of Technology
# @FileName   : Solution.py
# @Software   : PyCharm
# @github     : https://github.com/i-love-linux/LeetCode
# 爬楼梯


class Solution(object):
    # 动态规划
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n == 1:
            return 1

        memo = [-1 for _ in range(n + 1)]
        memo[0] = 1
        memo[1] = 1
        for i in range(2, n+1):
            memo[i] = memo[i-1] + memo[i-2]

        return memo[n]


if __name__ == "__main__":
    print(Solution().climbStairs(3))

