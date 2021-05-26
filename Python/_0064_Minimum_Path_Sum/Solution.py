# coding=utf-8
from typing import List


class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        n = len(grid); m = len(grid[0])
        f = [[int(1e8) for _ in range(m)] for _ in range(n)]
        for i in range(n):
            for j in range(m):
                if i == 0 and j == 0:
                    f[i][j] = grid[i][j]
                else:
                    if i > 0:
                        f[i][j] = min(f[i][j], f[i - 1][j] + grid[i][j])
                    if j > 0:
                        f[i][j] = min(f[i][j], f[i][j - 1] + grid[i][j])
        return f[n - 1][m - 1]


if __name__ == "__main__":
    print(Solution().minPathSum([[1, 3], [1, 1]]))  # 3
