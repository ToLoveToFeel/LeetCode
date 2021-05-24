# coding=utf-8
# Date: 2021/5/24 10:33
from typing import List


class Solution:
    def totalNQueens(self, n: int) -> int:
        col = [False for _ in range(n)]
        dg = [False for _ in range(2 * n - 1)]
        udg = [False for _ in range(2 * n - 1)]

        return self.dfs(0, n, col, dg, udg)

    def dfs(self, u, n, col, dg, udg):
        if u == n:
            return 1
        res = 0
        for i in range(n):
            if not col[i] and not dg[u - i + n - 1] and not udg[u + i]:
                col[i] = dg[u - i + n - 1] = udg[u + i] = True
                res += self.dfs(u + 1, n, col, dg, udg)
                col[i] = dg[u - i + n - 1] = udg[u + i] = False
        return res


if __name__ == "__main__":
    print(Solution().totalNQueens(4))  # 2
