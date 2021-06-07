# coding=utf-8
# Date: 2021/6/7 9:29
from typing import List


# 执行用时：2900 ms, 在所有 Python3 提交中击败了5.02%的用户
# 内存消耗：15.4 MB, 在所有 Python3 提交中击败了15.56%的用户
class Solution:
    def findTargetSumWays(self, a: List[int], target: int) -> int:
        if target < -1000 or target > 1000:
            return 0
        n = len(a)
        Offset = 1000
        f = [[0 for _ in range(2001)] for _ in range(n + 1)]
        f[0][Offset] = 1
        for i in range(1, n + 1):
            for j in range(-1000, 1001):
                if j - a[i - 1] >= -1000:
                    f[i][j + Offset] += f[i - 1][j - a[i - 1] + Offset]
                if j + a[i - 1] <= 1000:
                    f[i][j + Offset] += f[i - 1][j + a[i - 1] + Offset]
        return f[n][target + Offset]


if __name__ == "__main__":
    print(Solution().findTargetSumWays([1, 1, 1, 1, 1], 3))  # 5
