# coding=utf-8
# Date: 2021/5/23 21:55
from typing import List


# 执行用时：44 ms, 在所有 Python3 提交中击败了40.22%的用户
# 内存消耗：14.7 MB, 在所有 Python3 提交中击败了92.61%的用户
class Solution:
    def myPow(self, x: float, n: int) -> float:
        is_minus = n < 0
        k = abs(n)
        res = 1
        while k > 0:
            if (k & 1) == 1:
                res *= x
            x *= x
            k >>= 1
        if is_minus:
            res = 1 / res
        return res


if __name__ == "__main__":
    print(Solution().myPow(2.0, 10))
