# coding=utf-8
# Date: 2021/7/12 8:54
from typing import List


# 执行用时：44 ms, 在所有 Python3 提交中击败了62.83%的用户
# 内存消耗：19.1 MB, 在所有 Python3 提交中击败了5.20%的用户
class Solution:
    def hIndex(self, cs: List[int]) -> int:
        n = len(cs)
        l, r = 0, n
        while l < r:
            mid = l + r + 1 >> 1
            if cs[n - mid] >= mid:
                l = mid
            else:
                r = mid - 1
        return r


if __name__ == "__main__":
    print(Solution().hIndex([0, 1, 3, 5, 6]))  # 3
