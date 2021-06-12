# coding=utf-8
# Date: 2021/6/12 11:16
from typing import List


# 执行用时：564 ms, 在所有 Python3 提交中击败了5.48%的用户
# 内存消耗：16.5 MB, 在所有 Python3 提交中击败了90.41%的用户
class Solution:
    def largestNumber(self, cost: List[int], target: int) -> str:
        INF = (int) (2e9)
        n = len(cost)
        f = [[-INF for _ in range(target + 1)] for _ in range(n + 1)]
        f[0][0] = 0
        for i in range(1, n + 1):
            v = cost[i - 1]
            for j in range(target + 1):
                f[i][j] = f[i - 1][j]
                if j >= v:
                    f[i][j] = max(f[i][j], f[i][j - v] + 1)
        if f[n][target] < -INF // 2:
            return "0"
        j = target
        res = ""
        for i in range(n, 0, -1):
            v = cost[i - 1]
            while j >= v and f[i][j] == f[i][j - v] + 1:
                res += str(i)
                j -= v
        return res


if __name__ == "__main__":
    cost = [4, 3, 2, 5, 6, 7, 2, 5, 5]
    print(Solution().largestNumber(cost, 9))  # 7772
