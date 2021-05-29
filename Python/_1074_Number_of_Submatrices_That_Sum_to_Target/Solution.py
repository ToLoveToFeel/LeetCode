# coding=utf-8
# Date: 2021/5/29 15:03
from typing import List


# 执行用时：964 ms, 在所有 Python3 提交中击败了29.51%的用户
# 内存消耗：15.3 MB, 在所有 Python3 提交中击败了83.61%的用户
class Solution:
    def numSubmatrixSumTarget(self, matrix: List[List[int]], target: int) -> int:
        n = len(matrix); m = len(matrix[0])
        res = 0
        for i in range(n):
            nums = [0 for _ in range(m)]
            for j in range(i, n):
                for k in range(m):
                    nums[k] += matrix[j][k]
                res += self.subarraySum(nums, target)
        return res

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
    pass
