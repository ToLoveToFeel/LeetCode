# coding=utf-8
# Date: 2021/6/8 9:52
from typing import List


# 执行用时：68 ms, 在所有 Python3 提交中击败了57.92%的用户
# 内存消耗：15 MB, 在所有 Python3 提交中击败了38.66%的用户
class Solution:
    def lastStoneWeightII(self, stones: List[int]) -> int:
        s = sum(stones)
        m = s // 2
        f = [0 for _ in range(m + 1)]
        for x in stones:
            for j in range(m, x - 1, -1):
                f[j] = max(f[j], f[j - x] + x)
        return s - 2 * f[m]


if __name__ == "__main__":
    print(Solution().lastStoneWeightII([2, 7, 4, 1, 8, 1]))  # 1
