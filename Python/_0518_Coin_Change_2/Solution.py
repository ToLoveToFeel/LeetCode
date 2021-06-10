# coding=utf-8
# Date: 2021/6/10 10:11
from typing import List


# 执行用时：164 ms, 在所有 Python3 提交中击败了60.51%的用户
# 内存消耗：15.1 MB, 在所有 Python3 提交中击败了47.87%的用户
class Solution:
    def change(self, m: int, coins: List[int]) -> int:
        f = [0 for _ in range(m + 1)]
        f[0] = 1
        for v in coins:
            for j in range(v, m + 1):
                f[j] += f[j - v]
        return f[m]


if __name__ == "__main__":
    print(Solution().change(5, [1, 2, 5]))  # 4
