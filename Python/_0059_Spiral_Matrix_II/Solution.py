# coding=utf-8
# Date: 2021/5/24 17:04
from typing import List


class Solution:
    def generateMatrix(self, n: int) -> List[List[int]]:
        dx = [0, 1, 0, -1]; dy = [1, 0, -1, 0]
        res = [[0 for _ in range(n)] for _ in range(n)]
        x = 0; y = 0; d = 0
        for i in range(1, n * n + 1):
            res[x][y] = i
            a = x + dx[d]; b = y + dy[d]
            if a < 0 or a >= n or b < 0 or b >= n or res[a][b] != 0:
                d = (d + 1) % 4
                a = x + dx[d]; b = y + dy[d]
            x = a; y = b
        return res


if __name__ == "__main__":
    print(Solution().generateMatrix(3))  # [[1, 2, 3], [8, 9, 4], [7, 6, 5]]
