# coding=utf-8
# @Time       : 2020/3/7
# @Author     : Wang Xiaoxiao
# @University : Dalian University of Technology
# @FileName   : Solution.py
# @Software   : PyCharm
# @github     : https://github.com/i-love-linux/LeetCode
# 最小路径和


class Solution(object):
    def minPathSum(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        if len(grid) == 0 or len(grid[0]) == 0:
            return 0

        r = len(grid) - 1
        c = len(grid[0]) - 1
        dp = [[-1 for _ in range(c + 1)] for _ in range(r+1)]

        dp[r][c] = grid[r][c]
        for i in range(r - 1, -1, -1):
            dp[i][c] = dp[i+1][c] + grid[i][c]  # 填充最后一列的
        for j in range(c - 1, -1, -1):
            dp[r][j] = dp[r][j+1] + grid[r][j]  # 填充最后一行的

        for i in range(r - 1, -1, -1):  # 填充其他的
            for j in range(c - 1, -1, -1):
                dp[i][j] = min(dp[i+1][j], dp[i][j+1]) + grid[i][j]

        return dp[0][0]


if __name__ == "__main__":
    grid = [
              [1,3],
              [1,1]
            ]
    So = Solution()
    print(So.minPathSum(grid))



