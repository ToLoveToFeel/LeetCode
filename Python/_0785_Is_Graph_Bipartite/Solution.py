# coding=utf-8
# Date: 2021/6/7 14:45
from typing import List


# 执行用时：52 ms, 在所有 Python3 提交中击败了41.40%的用户
# 内存消耗：15.3 MB, 在所有 Python3 提交中击败了49.77%的用户
class Solution:
    def __init__(self):
        self.color = []
        self.g = []

    def isBipartite(self, graph: List[List[int]]) -> bool:
        self.g = graph
        n = len(self.g)
        self.color = [0 for _ in range(n)]

        for i in range(n):
            if self.color[i] == 0:
                if not self.dfs(i, 1):
                    return False
        return True

    def dfs(self, u, c):
        self.color[u] = c
        for w in self.g[u]:
            if self.color[w] == 0:
                if not self.dfs(w, 3 - c):
                    return False
            elif self.color[w] == c:
                return False
        return True


if __name__ == "__main__":
    print(Solution().isBipartite([[1, 2, 3], [0, 2], [0, 1, 3], [0, 2]]))  # False
