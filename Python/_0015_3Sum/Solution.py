# coding=utf-8
from typing import List


# 执行用时：1636 ms, 在所有 Python3 提交中击败了17.02%的用户
# 内存消耗：17.5 MB, 在所有 Python3 提交中击败了71.06%的用户
class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()

        res = []
        for i in range(len(nums)):
            if nums[i] > 0:
                break
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            j = i + 1; k = len(nums) - 1
            while j < k:
                if j > i + 1 and nums[j] == nums[j - 1]:
                    j += 1
                    continue
                while j < k - 1 and nums[i] + nums[j] + nums[k - 1] >= 0:
                    k -= 1
                if nums[i] + nums[j] + nums[k] == 0:
                    res.append([nums[i], nums[j], nums[k]])
                j += 1
        return res


if __name__ == "__main__":
    nums = [-1, 0, 1, 2, -1, -4]
    print(Solution().threeSum(nums))  # [[-1, -1, 2], [-1, 0, 1]]
