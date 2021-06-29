# coding=utf-8
# Date: 2021/6/29 22:24
from typing import List


# TLE
class Solution:
    def cherryPickup(self, grid: List[List[int]]) -> int:
        n = len(grid)
        N = 55
        f = [[[(int)(-1e8) for _ in range(N * 2)] for _ in range(N)] for _ in range(N)]
        f[1][1][2] = grid[0][0]
        for k in range(3, n * 2 + 1):
            for i in range(max(1, k - n), min(n, k - 1) + 1):
                for j in range(max(1, k - n), min(n, k - 1) + 1):
                    if grid[i - 1][k - i - 1] == -1 or grid[j - 1][k - j - 1] == -1:
                        continue
                    t = grid[i - 1][k - i - 1]
                    if i != j:
                        t += grid[j - 1][k - j - 1]
                    for a in range(i - 1, i + 1):
                        for b in range(j - 1, j + 1):
                            f[i][j][k] = max(f[i][j][k], f[a][b][k - 1] + t)
        return max(0, f[n][n][n * 2])


if __name__ == "__main__":
    print(Solution().cherryPickup([[0, 1, -1], [1, 0, -1], [1, 1, 1]]))  # 5
