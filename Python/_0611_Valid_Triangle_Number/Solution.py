# coding=utf-8
from typing import List


# 执行用时：1020 ms, 在所有 Python3 提交中击败了68.49%的用户
# 内存消耗：14.9 MB, 在所有 Python3 提交中击败了71.12%的用户
class Solution:
    def triangleNumber(self, nums: List[int]) -> int:
        nums.sort()
        res = 0
        for i in range(len(nums)):
            j, k = i - 1, 0
            while j >= 0 and k < j:
                while k < j and nums[k] + nums[j] <= nums[i]:
                    k += 1
                res += j - k
                j -= 1
        return res


if __name__ == "__main__":
    print(Solution().triangleNumber([2, 2, 3, 4]))  # 3
