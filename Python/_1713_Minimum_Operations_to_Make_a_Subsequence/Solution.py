# coding=utf-8
# Date: 2021/7/26 9:57
from typing import List


# 执行用时：516 ms, 在所有 Python3 提交中击败了7.41%的用户
# 内存消耗：36.8 MB, 在所有 Python3 提交中击败了96.30%的用户
class Solution:
    def minOperations(self, a: List[int], b: List[int]) -> int:
        N = 100010
        n, m = len(a), len(b)
        id = {}
        for i in range(n):
            id[a[i]] = i

        q = [0] * N
        res = 0
        for i in range(m):
            if b[i] not in id:
                continue
            k = id[b[i]]
            l, r = 0, res
            while l < r:
                mid = l + r + 1 >> 1
                if q[mid] < k:
                    l = mid
                else:
                    r = mid - 1
            q[r + 1] = k
            res = max(res, r + 1)
        return n - res


if __name__ == "__main__":
    pass
