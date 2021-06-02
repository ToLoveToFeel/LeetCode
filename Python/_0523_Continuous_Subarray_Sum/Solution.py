# coding=utf-8
# Date: 2021/6/2 9:17
from typing import List


# 执行用时：212 ms, 在所有 Python3 提交中击败了16.35%的用户
# 内存消耗：29.7 MB, 在所有 Python3 提交中击败了62.26%的用户
class Solution:
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        n = len(nums)
        s = [0 for _ in range(n + 1)]
        for i in range(1, n + 1):
            s[i] = s[i - 1] + nums[i - 1]
        hash = set()
        for i in range(2, n + 1):
            hash.add(s[i - 2] % k)
            if s[i] % k in hash:
                return True
        return False


if __name__ == "__main__":
    print(Solution().checkSubarraySum([23, 2, 4, 6, 7], k=6))  # True
