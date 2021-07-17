# coding=utf-8
# Date: 2021/7/17 15:01
from typing import List


# 执行用时：64 ms, 在所有 Python3 提交中击败了83.70%的用户
# 内存消耗：18.5 MB, 在所有 Python3 提交中击败了73.18%的用户
class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        f, res = nums[0], nums[0]
        for i in range(1, len(nums)):
            f = max(0, f) + nums[i]
            res = max(res, f)
        return res


if __name__ == "__main__":
    print(Solution().maxSubArray([-2, 1, -3, 4, -1, 2, 1, -5, 4]))  # 6
