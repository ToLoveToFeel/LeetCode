# coding=utf-8
# Date: 2021/6/6 10:58
from typing import List


# 执行用时：2796 ms, 在所有 Python3 提交中击败了93.12%的用户
# 内存消耗：15.2 MB, 在所有 Python3 提交中击败了49.55%的用户
class Solution:
    def findMaxForm(self, strs: List[str], m: int, n: int) -> int:
        f = [[0 for _ in range(n + 1)] for _ in range(m + 1)]
        for str in strs:
            a = 0; b = 0
            for c in str:
                if c =='0':
                    a += 1
                else:
                    b += 1
            for i in range(m, a - 1, -1):
                for j in range(n, b - 1, -1):
                    f[i][j] = max(f[i][j], f[i - a][j - b] + 1)
        return f[m][n]


if __name__ == "__main__":
    strs = ["10", "0001", "111001", "1", "0"]
    print(Solution().findMaxForm(strs, 5, 3))  # 4
