# coding=utf-8
# Date: 2021/6/3 9:30
from typing import List


# 执行用时：296 ms, 在所有 Python3 提交中击败了73.05%的用户
# 内存消耗：19.7 MB, 在所有 Python3 提交中击败了19.15%的用户
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        n = len(nums)
        hash = {}
        hash[0] = 0
        res = 0; zero = 0; one = 0
        for i in range(1, n + 1):
            x = nums[i - 1]
            if x == 0:
                zero += 1
            else:
                one += 1
            s = one - zero
            if s in hash:
                res = max(res, i - hash[s])
            else:
                hash[s] = i
        return res


if __name__ == "__main__":
    print(Solution().findMaxLength([0, 1]))  # 2
