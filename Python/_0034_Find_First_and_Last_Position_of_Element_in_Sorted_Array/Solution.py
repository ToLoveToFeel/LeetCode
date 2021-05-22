# coding=utf-8
# Date: 2021/5/22 9:59
from typing import List


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if len(nums) == 0:
            return [-1, -1]
        l = 0; r = len(nums) - 1
        while l < r:
            mid = l + r >> 1
            if nums[mid] >= target:
                r = mid
            else:
                l = mid + 1
        if nums[r] != target:
            return [-1, -1]

        L = l
        l = 0; r = len(nums) - 1
        while l < r:
            mid = l + r + 1 >> 1
            if nums[mid] <= target:
                l = mid
            else:
                r = mid - 1
        return [L, r]


if __name__ == "__main__":
    nums = [5, 7, 7, 8, 8, 10]
    print(Solution().searchRange(nums, 8))  # [3, 4]
