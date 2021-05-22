# coding=utf-8
# Date: 2021/5/22 21:40
from typing import List


# 执行用时：40 ms, 在所有 Python3 提交中击败了71.36%的用户
# 内存消耗：14.9 MB, 在所有 Python3 提交中击败了40.73%的用户
class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)
        f = [0 for _ in range(n)]
        j = 0
        for i in range(1, n):
            while j + nums[j] < i:
                j += 1
            f[i] = f[j] + 1
        return f[n - 1]


if __name__ == "__main__":
    print(Solution().jump([2, 3, 1, 1, 4]))  # 2
