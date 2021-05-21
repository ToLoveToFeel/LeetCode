# coding=utf-8
from typing import List


# 执行用时：48 ms, 在所有 Python3 提交中击败了63.98%的用户
# 内存消耗：15.8 MB, 在所有 Python3 提交中击败了64.03%的用户
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        T = 1
        k = 0
        for i in range(len(nums)):
            if k - T < 0 or nums[i] != nums[k - T]:
                nums[k] = nums[i]
                k += 1
        return k


if __name__ == "__main__":
    print(Solution().removeDuplicates([1, 1, 2]))  # 2
