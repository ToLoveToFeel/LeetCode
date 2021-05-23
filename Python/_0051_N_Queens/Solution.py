# coding=utf-8
# Date: 2021/5/23 22:08
from typing import List


# 执行用时：80 ms, 在所有 Python3 提交中击败了46.97%的用户
# 内存消耗：15.1 MB, 在所有 Python3 提交中击败了92.87%的用户
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        col = [False for _ in range(n)]
        dg = [False for _ in range(2 * n + 1)]
        udg = [False for _ in range(2 * n + 1)]

        ans = []
        path = [['.' for _ in range(n)] for _ in range(n)]
        self.dfs(0, n, col, dg, udg, path, ans)
        return ans

    def dfs(self, u, n, col, dg, udg, path, ans):
        if u == n:
            t = []
            for i in range(n):
                t.append("".join(path[i]))
            ans.append(t)
            return
        for i in range(n):
            if not col[i] and not dg[u - i + n - 1] and not udg[u + i]:
                col[i] = dg[u - i + n - 1] = udg[u + i] = True
                path[u][i] = 'Q'
                self.dfs(u + 1, n, col, dg, udg, path, ans)
                path[u][i] = '.'
                col[i] = dg[u - i + n - 1] = udg[u + i] = False


if __name__ == "__main__":
    print(Solution().solveNQueens(4))  # [['.Q..', '...Q', 'Q...', '..Q.'], ['..Q.', 'Q...', '...Q', '.Q..']]
