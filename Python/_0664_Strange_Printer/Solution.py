# coding=utf-8
# Date: 2021/5/24 11:32
from typing import List


# 执行用时：556 ms, 在所有 Python3 提交中击败了69.46%的用户
# 内存消耗：15.2 MB, 在所有 Python3 提交中击败了29.01%的用户
class Solution:
    def strangePrinter(self, s: str) -> int:
        n = len(s)
        f = [[0 for _ in range(n)] for _ in range(n + 1)]
        for l in range(1, n + 1):
            for i in range(0, n - (l - 1)):
                j = i + l - 1
                f[i][j] = f[i + 1][j] + 1
                for k in range(i + 1, j + 1):
                    if s[i] == s[k]:
                        f[i][j] = min(f[i][j], f[i][k - 1] + f[k + 1][j])
        return f[0][n - 1]


if __name__ == "__main__":
    print(Solution().strangePrinter("aaabbb"))  # 2
