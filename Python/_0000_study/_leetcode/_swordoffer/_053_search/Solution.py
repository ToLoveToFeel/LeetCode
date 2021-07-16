# coding=utf-8
# Date: 2021/7/16 9:48
from typing import List


# 执行用时：32 ms, 在所有 Python3 提交中击败了95.55%的用户
# 内存消耗：15.6 MB, 在所有 Python3 提交中击败了26.71%的用户
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if len(nums) == 0:
            return 0
        l, r = 0, len(nums) - 1
        while l < r:
            mid = l + r >> 1
            if nums[mid] >= target:
                r = mid
            else:
                l = mid + 1
        if nums[r] != target:
            return 0

        L = l
        l, r = 0, len(nums) - 1
        while l < r:
            mid = l + r + 1 >> 1
            if nums[mid] <= target:
                l = mid
            else:
                r = mid - 1
        return r - L + 1


if __name__ == "__main__":
    print(Solution().search([5, 7, 7, 8, 8, 10], 8))  # 2
