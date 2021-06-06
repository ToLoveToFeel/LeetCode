# coding=utf-8
# Date: 2021/6/6 11:27
from typing import List


# 执行用时：44 ms, 在所有 Python3 提交中击败了91.50%的用户
# 内存消耗：15 MB, 在所有 Python3 提交中击败了86.82%的用户
class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        p = [i for i in range(1010)]

        for edge in edges:
            a = self.find(p, edge[0]); b = self.find(p, edge[1])
            if a != b:
                p[a] = b
            else:
                return edge
        return []

    def find(self, p, x):
        if x != p[x]:
            p[x] = self.find(p, p[x])
        return p[x]


if __name__ == "__main__":
    edges = [[1, 2], [1, 3], [2, 3]]
    print(Solution().findRedundantConnection(edges))  # [2, 3]
