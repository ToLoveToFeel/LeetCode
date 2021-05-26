# coding=utf-8
from typing import List


class Solution:
    def canJump(self, nums: List[int]) -> bool:
        j = 0
        for i in range(len(nums)):
            if j < i:
                return False
            j = max(j, i + nums[i])
        return True


if __name__ == "__main__":
    print(Solution().canJump([2, 3, 1, 1, 4]))
