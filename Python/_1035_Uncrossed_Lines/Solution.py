# coding=utf-8
from typing import List


# 执行用时：200 ms, 在所有 Python3 提交中击败了64.75%的用户
# 内存消耗：15.2 MB, 在所有 Python3 提交中击败了47.12%的用户
class Solution:
    def maxUncrossedLines(self, nums1: List[int], nums2: List[int]) -> int:
        n = len(nums1); m = len(nums2)
        f = [[0 for _ in range(m + 1)] for _ in range(n + 1)]
        for i in range(1, n + 1):
            for j in range(1, m + 1):
                f[i][j] = max(f[i - 1][j], f[i][j - 1])
                if nums1[i - 1] == nums2[j - 1]:
                    f[i][j] = max(f[i][j], f[i - 1][j - 1] + 1)
        return f[n][m]


if __name__ == "__main__":
    print(Solution().maxUncrossedLines([1, 4, 2], [1, 2, 4]))  # 2
