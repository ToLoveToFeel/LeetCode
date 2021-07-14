# coding=utf-8
# Date: 2021/7/14 10:19
from typing import List


# 执行用时：860 ms, 在所有 Python3 提交中击败了35.67%的用户
# 内存消耗：26.9 MB, 在所有 Python3 提交中击败了69.94%的用户
class Solution:
    def minAbsoluteSumDiff(self, nums1: List[int], nums2: List[int]) -> int:
        mod = int(1e9) + 7
        n = len(nums1)
        a = nums1.copy()
        a.sort()
        sum, d = 0, 0
        for i in range(n):
            t = abs(nums1[i] - nums2[i])
            sum = (sum + t) % mod
            l, r = 0, n
            while l < r:
                mid = l + r >> 1
                if a[mid] >= nums2[i]:
                    r = mid
                else:
                    l = mid + 1
            if r < n:
                d = max(d, t - abs(a[r] - nums2[i]))
            if r > 0:
                d = max(d, t - abs(a[r - 1] - nums2[i]))
        return (sum - d + mod) % mod


if __name__ == "__main__":
    print(Solution().minAbsoluteSumDiff([1, 28, 21], [9, 21, 20]))  # 9
