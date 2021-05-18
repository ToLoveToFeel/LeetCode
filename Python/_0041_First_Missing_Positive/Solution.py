# coding=utf-8
from typing import List


# 执行用时：164 ms, 在所有 Python3 提交中击败了5.10%的用户
# 内存消耗：41.1 MB, 在所有 Python3 提交中击败了5.16%的用户
class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        n = len(nums)
        for i in range(0, n):
            while 0 < nums[i] <= n and nums[i] != nums[nums[i] - 1]:
                nums[nums[i] - 1], nums[i] = nums[i], nums[nums[i] - 1]
        for i in range(0, n):
            if nums[i] != i + 1:
                return i + 1
        return n + 1


if __name__ == "__main__":
    print(Solution().firstMissingPositive([3, 4, -1, 1]))
