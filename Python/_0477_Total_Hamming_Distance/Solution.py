# coding=utf-8
# Date: 2021/5/28 9:20
from typing import List


# 执行用时：420 ms, 在所有 Python3 提交中击败了69.50%的用户
# 内存消耗：15.8 MB, 在所有 Python3 提交中击败了81.00%的用户
class Solution:
    def totalHammingDistance(self, nums: List[int]) -> int:
        res = 0
        for i in range(30, -1, -1):
            x = 0; y = 0
            for c in nums:
                if c >> i & 1:
                    x += 1
                else:
                    y += 1
            res += x * y
        return res


if __name__ == "__main__":
    print(Solution().totalHammingDistance([4, 12, 2]))  # 6
