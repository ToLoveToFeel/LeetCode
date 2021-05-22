# coding=utf-8
# Date: 2021/5/22 10:01
from typing import List


class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        l = 0; r = len(nums)
        while l < r:
            mid = l + r >> 1
            if nums[mid] >= target:
                r = mid
            else:
                l = mid + 1
        return r


if __name__ == "__main__":
    nums = [1, 3, 5, 6]
    print(Solution().searchInsert(nums, 5))  # 2
