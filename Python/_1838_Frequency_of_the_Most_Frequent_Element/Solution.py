# coding=utf-8
# Date: 2021/7/19 10:33
from typing import List


# 执行用时：3336 ms, 在所有 Python3 提交中击败了13.49%的用户
# 内存消耗：25.8 MB, 在所有 Python3 提交中击败了9.18%的用户
class Solution:
    def maxFrequency(self, nums: List[int], k: int) -> int:
        n = len(nums)
        nums.sort()
        s = [0] * (n + 1)
        for i in range(1, n + 1):
            s[i] = s[i - 1] + nums[i - 1]
        res = 0
        for i in range(1, n + 1):
            l, r = 1, i
            while l < r:
                mid = l + r >> 1
                t = (i - mid + 1) * nums[i - 1] - (s[i] - s[mid - 1])
                if t <= k:
                    r = mid
                else:
                    l = mid + 1
            res = max(res, i - l + 1)
        return res


if __name__ == "__main__":
    pass
