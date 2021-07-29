# coding=utf-8
# Date: 2021/7/29 10:01
from typing import List
from math import log2


# 执行用时：28 ms, 在所有 Python3 提交中击败了93.75%的用户
# 内存消耗：15 MB, 在所有 Python3 提交中击败了11.72%的用户
class Solution:
    def pathInZigZagTree(self, t: int) -> List[int]:
        p = [1] * 25
        for i in range(1, 25):
            p[i] = p[i - 1] * 2
        n = int(log2(t)) + 1
        res = [t]
        while n > 1:
            t = p[n - 2] + p[n - 1] - 1 - t // 2
            res.append(t)
            n -= 1
        return res[::-1]


if __name__ == "__main__":
    print(Solution().pathInZigZagTree(14))
