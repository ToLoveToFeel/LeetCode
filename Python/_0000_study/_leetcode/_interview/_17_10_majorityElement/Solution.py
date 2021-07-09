# coding=utf-8
# Date: 2021/7/9 9:36
from typing import List


# 执行用时：40 ms, 在所有 Python3 提交中击败了97.75%的用户
# 内存消耗：16.3 MB, 在所有 Python3 提交中击败了5.10%的用户
class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        n = len(nums)
        cnt = {}
        for x in nums:
            if x not in cnt:
                cnt[x] = 0
            cnt[x] += 1
        for k, v in cnt.items():
            if v > n // 2:
                return k
        return -1


if __name__ == "__main__":
    print(Solution().majorityElement([1, 2, 5, 9, 5, 9, 5, 5, 5]))  # 5
