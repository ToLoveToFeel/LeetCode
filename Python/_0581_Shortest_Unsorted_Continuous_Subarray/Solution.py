# coding=utf-8
# Date: 2021/7/16 22:00
from typing import List


# 执行用时：48 ms, 在所有 Python3 提交中击败了96.45%的用户
# 内存消耗：15.7 MB, 在所有 Python3 提交中击败了51.45%的用户
class Solution:
    def findUnsortedSubarray(self, nums: List[int]) -> int:
        l, r = 0, len(nums) - 1
        # 处理左端点
        while l + 1 < len(nums) and nums[l + 1] >= nums[l]:
            l += 1
        if l == r:  # 说明整个数组都是升序的
            return 0
        for i in range(l + 1, len(nums)):
            while l >= 0 and nums[l] > nums[i]:
                l -= 1
        # 处理右端点
        while r - 1 >= 0 and nums[r - 1] <= nums[r]:
            r -= 1
        for i in range(r - 1, -1, -1):
            while r < len(nums) and nums[r] < nums[i]:
                r += 1
        return r - l - 1


if __name__ == "__main__":
    print(Solution().findUnsortedSubarray([2, 6, 4, 8, 10, 9, 15]))  # 5
