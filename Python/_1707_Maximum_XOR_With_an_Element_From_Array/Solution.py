# coding=utf-8
# Date: 2021/5/23 11:25
from typing import List


# TLE
class Solution:
    class Node:
        def __init__(self):
            self.son = [None] * 2
            self.min = int(2e9)

    def maximizeXor(self, nums: List[int], queries: List[List[int]]) -> List[int]:
        root = self.Node()
        for x in nums:
            self.insert(root, x)
        res = []
        for i in range(len(queries)):
            x = queries[i][0]
            m = queries[i][1]
            res.append(self.query(root, x, m))
        return res

    def insert(self, root, val):
        p = root
        p.min = min(p.min, val)
        for i in range(29, -1, -1):
            u = val >> i & 1
            if p.son[u] is None:
                p.son[u] = self.Node()
            p = p.son[u]
            p.min = min(p.min, val)

    def query(self, root, x, m):
        p = root
        if p.min > m:
            return -1
        res = 0
        for i in range(29, -1, -1):
            u = x >> i & 1
            if p.son[1 ^ u] and p.son[1 ^ u].min <= m:
                p = p.son[1 - u]
                res = res * 2 + 1 - u
            else:
                p = p.son[u]
                res = res * 2 + u
        return res ^ x


if __name__ == "__main__":
    nums = [5, 2, 4, 6, 6, 3]
    queries = [[12, 4], [8, 1], [6, 3]]
    print(Solution().maximizeXor(nums, queries))
