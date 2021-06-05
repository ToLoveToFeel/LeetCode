# coding=utf-8
# Date: 2021/6/5 14:44
from typing import List


# 执行用时：188 ms, 在所有 Python3 提交中击败了24.93%的用户
# 内存消耗：26.9 MB, 在所有 Python3 提交中击败了5.05%的用户
class Solution:
    def find132pattern(self, nums: List[int]) -> bool:
        stk = []
        right = -2e9
        for x in nums[::-1]:
            if x < right:
                return True
            while len(stk) > 0 and x > stk[len(stk) - 1]:
                right = max(right, stk[len(stk) - 1])
                stk.pop(len(stk) - 1)
            stk.append(x)
        return False


if __name__ == "__main__":
    print(Solution().find132pattern([1, 2, 3, 4]))  # False
