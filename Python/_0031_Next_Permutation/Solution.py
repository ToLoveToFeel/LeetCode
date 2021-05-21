# coding=utf-8
# Date: 2021/5/21 21:17
from typing import List


# 执行用时：32 ms, 在所有 Python3 提交中击败了95.50%的用户
# 内存消耗：14.8 MB, 在所有 Python3 提交中击败了66.02%的用户
class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        k = len(nums) - 1
        while k > 0 and nums[k - 1] >= nums[k]:
            k -= 1

        if k == 0:
            self.reverse(nums, 0, len(nums) - 1)
        else:
            t = k
            while t < len(nums) and nums[t] > nums[k - 1]:
                t += 1
            nums[k - 1], nums[t - 1] = nums[t - 1], nums[k - 1]
            self.reverse(nums, k, len(nums) - 1)

    def reverse(self, nums, i, j):
        while i < j:
            nums[i], nums[j] = nums[j], nums[i]
            i += 1; j -= 1


if __name__ == "__main__":
    nums = [1, 2, 3]
    Solution().nextPermutation(nums)
    print(nums)  # [1, 3, 2]
