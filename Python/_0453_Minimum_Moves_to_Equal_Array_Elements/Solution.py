# coding=utf-8
# Date: 2021/6/4 10:20
from typing import List


# 执行用时：56 ms, 在所有 Python3 提交中击败了67.45%的用户
# 内存消耗：15.6 MB, 在所有 Python3 提交中击败了89.60%的用户
class Solution:
    def minMoves(self, nums: List[int]) -> int:
        return sum(nums) - min(nums) * len(nums)


if __name__ == "__main__":
    print(Solution().minMoves([1, 2, 3]))  # 3
