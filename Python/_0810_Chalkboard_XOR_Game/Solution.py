# coding=utf-8
# Date: 2021/5/22 9:37
from typing import List


# 执行用时：80 ms, 在所有 Python3 提交中击败了93.94%的用户
# 内存消耗：14.8 MB, 在所有 Python3 提交中击败了96.97%的用户
class Solution:
    def xorGame(self, nums: List[int]) -> bool:
        s = 0
        for x in nums:
            s ^= x
        return s == 0 or len(nums) % 2 == 0


if __name__ == "__main__":
    print(Solution().xorGame([1, 1, 2]))  # False
