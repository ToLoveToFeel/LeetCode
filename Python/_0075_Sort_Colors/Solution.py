# coding=utf-8
# Date: 2021/5/26 16:58
from typing import List


class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        i = 0; j = 0; k = len(nums) - 1
        while i <= k:
            if nums[i] == 0:
                nums[j], nums[i] = nums[i], nums[j]
                i += 1; j += 1
            elif nums[i] == 2:
                nums[i], nums[k] = nums[k], nums[i]
                k -= 1
            else:
                i += 1


if __name__ == "__main__":
    pass
