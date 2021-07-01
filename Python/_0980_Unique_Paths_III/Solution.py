# coding=utf-8
# Date: 2021/7/1 14:40
from typing import List


# 执行用时：100 ms, 在所有 Python3 提交中击败了20.00%的用户
# 内存消耗：15.2 MB, 在所有 Python3 提交中击败了10.94%的用户
class Solution:
    def __init__(self):
        self.n, self.m = 0, 0
        self.st = []
        self.S, self.T = [0, 0], [0, 0]
        self.ans = 0
        self.dx, self.dy = [-1, 0, 1, 0], [0, 1, 0, -1]

    def uniquePathsIII(self, grid: List[List[int]]) -> int:
        self.n, self.m = len(grid), len(grid[0])
        self.st = [[False for _ in range(self.m)] for _ in range(self.n)]
        self.ans = 0

        cnt = self.n * self.m
        for i in range(self.n):
            for j in range(self.m):
                if grid[i][j] == 1:
                    self.S = [i, j]
                elif grid[i][j] == 2:
                    self.T = [i, j]
                elif grid[i][j] == -1:
                    cnt -= 1
        self.dfs(grid, self.S[0], self.S[1], cnt - 1)
        return self.ans

    def dfs(self, grid, x, y, cnt):

        if cnt == 0 and x == self.T[0] and y == self.T[1]:
            self.ans += 1
            return

        self.st[x][y] = True
        for i in range(4):
            a, b = x + self.dx[i], y + self.dy[i]
            if 0 <= a < self.n and 0 <= b < self.m and not self.st[a][b] and grid[a][b] != -1:
                self.dfs(grid, a, b, cnt - 1)
        self.st[x][y] = False


if __name__ == "__main__":
    print(Solution().uniquePathsIII([[1, 0, 0, 0], [0, 0, 0, 0], [0, 0, 2, -1]]))
