# coding=utf-8
# Date: 2021/7/20 9:44
from typing import List


# 执行用时：304 ms, 在所有 Python3 提交中击败了74.83%的用户
# 内存消耗：25.6 MB, 在所有 Python3 提交中击败了40.95%的用户
class Solution:
    def minPairSum(self, nums: List[int]) -> int:
        nums.sort()
        i, j = 0, len(nums) - 1
        res = 0
        while i < j:
            res = max(res, nums[i] + nums[j])
            i += 1
            j -= 1
        return res


if __name__ == "__main__":
    print(Solution().minPairSum([3, 5, 2, 3]))  # 7
