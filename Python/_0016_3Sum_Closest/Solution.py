# coding=utf-8
from typing import List


# 执行用时：684 ms, 在所有 Python3 提交中击败了5.22%的用户
# 内存消耗：14.8 MB, 在所有 Python3 提交中击败了79.01%的用户
class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        nums.sort()
        res = [1e9, 1e9]
        for i in range(len(nums)):
            j = i + 1; k = len(nums) - 1
            while j < k:
                while j < k - 1 and nums[i] + nums[j] + nums[k - 1] >= target:
                    k -= 1
                s = nums[i] + nums[j] + nums[k]
                res = min(res, [abs(s - target), s])
                if j < k - 1:
                    s = nums[i] + nums[j] + nums[k - 1]
                    res = min(res, [abs(s - target), s])
                j += 1
        return int(res[1])


if __name__ == "__main__":
    print(Solution().threeSumClosest([-1, 2, 1, -4], 1))  # 2
    print(Solution().threeSumClosest([1, 1, -1, -1, 3], 3))  # 3
