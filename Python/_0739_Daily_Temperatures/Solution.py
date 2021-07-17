# coding=utf-8
# Date: 2021/7/17 16:23
from typing import List


# 执行用时：452 ms, 在所有 Python3 提交中击败了39.00%的用户
# 内存消耗：20 MB, 在所有 Python3 提交中击败了37.83%的用户
class Solution:
    def dailyTemperatures(self, t: List[int]) -> List[int]:
        n = len(t)
        res = [0] * n
        stk = []
        for i in range(n):
            while len(stk) != 0 and t[stk[len(stk) - 1]] < t[i]:
                res[stk[len(stk) - 1]] = i - stk[len(stk) - 1]
                stk.pop(len(stk) - 1)
            stk.append(i)
        return res


if __name__ == "__main__":
    print(Solution().dailyTemperatures([73, 74, 75, 71, 69, 72, 76, 73]))
