# coding=utf-8
# Date: 2021/7/1 10:40
from typing import List


# 执行用时：44 ms, 在所有 Python3 提交中击败了67.23%的用户
# 内存消耗：14.8 MB, 在所有 Python3 提交中击败了88.24%的用户
class Solution:
    def numWays(self, n: int, relation: List[List[int]], k: int) -> int:
        f = [[0 for _ in range(n)] for _ in range(k + 1)]
        f[0][0] = 1
        for i in range(1, k + 1):
            for edge in relation:
                f[i][edge[1]] += f[i - 1][edge[0]]
        return f[k][n - 1]


if __name__ == "__main__":
    print(Solution().numWays(5, [[0, 2], [2, 1], [3, 4], [2, 3], [1, 4], [2, 0], [0, 4]], 3))  # 3
