# coding=utf-8
from typing import List


# 执行用时：36 ms, 在所有 Python3 提交中击败了83.55%的用户
# 内存消耗：14.7 MB, 在所有 Python3 提交中击败了82.98%的用户
class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        k = 0
        for i in range(len(nums)):
            if nums[i] != val:
                nums[k] = nums[i]
                k += 1
        return k


if __name__ == "__main__":
    print(Solution().removeElement([3, 2, 2, 3], 3))  # 2
