# coding=utf-8
# Date: 2021/6/16 9:14
from typing import List


# 执行用时：312 ms, 在所有 Python3 提交中击败了33.41%的用户
# 内存消耗：20.4 MB, 在所有 Python3 提交中击败了19.69%的用户
class Solution:
    def stoneGame(self, piles: List[int]) -> bool:
        n = len(piles)
        f = [[0 for _ in range(n)] for _ in range(n)]
        for i in range(n):
            f[i][i] = piles[i]
        for l in range(2, n + 1):
            for i in range(n - l + 1):
                j = i + l - 1
                f[i][j] = max(f[i + 1][j] + piles[i], f[i][j - 1] + piles[j])
        return f[0][n - 1] > min(f[1][n - 1], f[0][n - 2])


if __name__ == "__main__":
    print(Solution().stoneGame([5, 3, 4, 5]))  # True
