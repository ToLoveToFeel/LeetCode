# coding=utf-8
# Date: 2021/5/29 14:28
from typing import List


# 执行用时：112 ms, 在所有 Python3 提交中击败了22.72%的用户
# 内存消耗：17.1 MB, 在所有 Python3 提交中击败了17.98%的用户
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        n = len(nums)
        s = [0 for _ in range(n + 1)]
        for i in range(1, n + 1):
            s[i] = s[i - 1] + nums[i - 1]
        hash = {}
        hash[0] = 1
        res = 0
        for i in range(1, n + 1):
            if s[i] - k in hash:
                res += hash[s[i] - k]
            if s[i] in hash:
                hash[s[i]] += 1
            else:
                hash[s[i]] = 1
        return res


if __name__ == "__main__":
    print(Solution().subarraySum([1, 1, 1], 2))  # 2
