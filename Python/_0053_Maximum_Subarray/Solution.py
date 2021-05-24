# coding=utf-8
# Date: 2021/5/24 10:35
from typing import List


class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        f = nums[0]
        res = nums[0]
        for i in range(1, len(nums)):
            f = max(f, 0) + nums[i]
            res = max(res, f)
        return res


if __name__ == "__main__":
    print(Solution().maxSubArray([-2, 1, -3, 4, -1, 2, 1, -5, 4]))  # 6
