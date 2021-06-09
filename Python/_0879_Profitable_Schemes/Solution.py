# coding=utf-8
# Date: 2021/6/9 11:08
from typing import List


# 执行用时：1584 ms, 在所有 Python3 提交中击败了59.54%的用户
# 内存消耗：15.1 MB, 在所有 Python3 提交中击败了65.13%的用户
class Solution:
    def profitableSchemes(self, n: int, m: int, group: List[int], profit: List[int]) -> int:
        mod = (int)(1e9 + 7)
        f = [[0 for _ in range(m + 1)] for _ in range(n + 1)]
        for i in range(n + 1):
            f[i][0] = 1
        for i in range(len(group)):
            g = group[i]
            p = profit[i]
            for j in range(n, g - 1, -1):
                for k in range(m, -1, -1):
                    f[j][k] = (f[j][k] + f[j - g][max(0, k - p)]) % mod
        return f[n][m]


if __name__ == "__main__":
    print(Solution().profitableSchemes(5, 3, [2, 2], [2, 3]))  # 2
