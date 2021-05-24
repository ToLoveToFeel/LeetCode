# coding=utf-8
# Date: 2021/5/24 17:13
from typing import List


class Solution:
    def uniquePathsWithObstacles(self, obs: List[List[int]]) -> int:
        m = len(obs); n = len(obs[0])
        f = [[0 for _ in range(n)] for _ in range(m)]
        for i in range(m):
            for j in range(n):
                if obs[i][j] == 0:
                    if i == 0 and j == 0:
                        f[i][j] = 1
                    else:
                        if i > 0:
                            f[i][j] += f[i - 1][j]
                        if j > 0:
                            f[i][j] += f[i][j - 1]
        return f[m - 1][n - 1]


if __name__ == "__main__":
    print(Solution().uniquePathsWithObstacles([[0, 0, 0], [0, 1, 0], [0, 0, 0]]))  # 2
