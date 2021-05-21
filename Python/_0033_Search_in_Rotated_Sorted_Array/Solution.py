# coding=utf-8
# Date: 2021/5/21 21:36
from typing import List


# 执行用时：44 ms, 在所有 Python3 提交中击败了38.71%的用户
# 内存消耗：15.3 MB, 在所有 Python3 提交中击败了5.03%的用户
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l = 0; r = len(nums) - 1
        while l < r:
            mid = l + r + 1 >> 1
            if nums[mid] >= nums[0]:
                l = mid
            else:
                r = mid - 1

        if target >= nums[0]:
            l = 0
        else:
            l = r + 1
            r = len(nums) - 1
        while l < r:
            mid = l + r >> 1
            if nums[mid] >= target:
                r = mid
            else:
                l = mid + 1

        if nums[r] == target:
            return r
        else:
            return -1


if __name__ == "__main__":
    nums = [4, 5, 6, 7, 0, 1, 2]
    print(Solution().search(nums, 0))  # 4
