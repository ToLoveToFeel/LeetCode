# coding=utf-8
# Date: 2021/6/5 20:43
from typing import List


# 执行用时：36 ms, 在所有 Python3 提交中击败了99.08%的用户
# 内存消耗：15.5 MB, 在所有 Python3 提交中击败了81.04%的用户
class Solution:
    def minMoves2(self, nums: List[int]) -> int:
        n = len(nums)
        nums.sort()
        res = 0
        for i in range(n):
            res += abs(nums[i] - nums[n // 2])
        return res


if __name__ == "__main__":
    print(Solution().minMoves2([1, 2, 3]))  # 2
