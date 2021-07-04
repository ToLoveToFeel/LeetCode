# coding=utf-8
# Date: 2021/7/4 11:46
from typing import List


# 执行用时：80 ms, 在所有 Python3 提交中击败了36.09%的用户
# 内存消耗：15.9 MB, 在所有 Python3 提交中击败了60.03%的用户
class Solution:
    def findErrorNums(self, nums: List[int]) -> List[int]:
        res = [0] * 2
        for x in nums:
            k = abs(x)
            if nums[k - 1] < 0:
                res[0] = k
            nums[k - 1] *= -1
        for i in range(len(nums)):
            if nums[i] > 0 and i + 1 != res[0]:
                res[1] = i + 1
                break
        return res


if __name__ == "__main__":
    print(Solution().findErrorNums([1, 2, 2, 3]))  # [2, 3]
