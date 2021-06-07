# coding=utf-8
# Date: 2021/6/7 15:44
from typing import List


# 执行用时：44 ms, 在所有 Python3 提交中击败了75.00%的用户
# 内存消耗：15.1 MB, 在所有 Python3 提交中击败了56.25%的用户
class Solution:
    def __init__(self):
        self.m = 0
        self.n = 0
        self.g = []  # 坏的为True
        self.match = []
        self.st = []
        self.dx = [-1, 0, 1, 0]
        self.dy = [0, 1, 0, -1]

    def domino(self, _n: int, _m: int, broken: List[List[int]]) -> int:
        self.m = _m
        self.n = _n
        self.g = [[False for _ in range(self.m)] for _ in range(self.n)]
        self.match = [-1 for _ in range(self.n * self.m)]
        self.st = [False for _ in range(self.n * self.m)]
        for i in range(len(broken)):
            a = broken[i][0]; b = broken[i][1]
            self.g[a][b] = True

        res = 0
        for i in range(self.n):
            for j in range(self.m):
                if (i + j) % 2 != 0 and not self.g[i][j]:
                    self.st = [False for _ in range(self.n * self.m)]
                    if self.find(i * self.m + j):
                        res += 1
        return res

    def find(self, x):
        for i in range(4):
            a = x // self.m + self.dx[i]
            b = x % self.m + self.dy[i]
            if a < 0 or a >= self.n or b < 0 or b >= self.m or self.g[a][b]:
                continue

            j = a * self.m + b
            if not self.st[j]:
                self.st[j] = True
                if self.match[j] == -1 or self.find(self.match[j]):
                    self.match[j] = x
                    return True
        return False


if __name__ == "__main__":
    print(Solution().domino(2, 3, [[1, 0], [1, 1]]))  # 2
