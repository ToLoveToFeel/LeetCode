# coding=utf-8
from typing import List

# 执行用时：1660 ms, 在所有 Python3 提交中击败了10.68%的用户
# 内存消耗：14.8 MB, 在所有 Python3 提交中击败了93.48%的用户
class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        nums.sort()

        res = []
        for i in range(len(nums)):
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            for j in range(i + 1, len(nums)):
                if j > i + 1 and nums[j] == nums[j - 1]:
                    continue
                k = j + 1; u = len(nums) - 1
                while k < u:
                    if k > j + 1 and nums[k] == nums[k - 1]:
                        k += 1
                        continue
                    while k < u - 1 and nums[i] + nums[j] + nums[k] + nums[u - 1] >= target:
                        u -= 1
                    if nums[i] + nums[j] + nums[k] + nums[u] == target:
                        res.append([nums[i], nums[j], nums[k], nums[u]])
                    k += 1
        return res


if __name__ == "__main__":
    nums = [1, 0, -1, 0, -2, 2]
    print(Solution().fourSum(nums, 0))
