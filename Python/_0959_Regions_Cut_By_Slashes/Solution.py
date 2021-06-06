# coding=utf-8
# Date: 2021/6/6 15:53
from typing import List


# 执行用时：164 ms, 在所有 Python3 提交中击败了74.48%的用户
# 内存消耗：15.1 MB, 在所有 Python3 提交中击败了80.00%的用户
class Solution:
    def __init__(self):
        self.cnt = 0

    def regionsBySlashes(self, grid: List[str]) -> int:
        n = len(grid)
        p = [i for i in range(n * n * 4)]
        self.cnt = n * n * 4
        for i in range(n):
            for j in range(n):
                id = i * n + j
                if i < n - 1:
                    self.merge(p, id * 4 + 2, (id + n) * 4 + 0)
                if j < n - 1:
                    self.merge(p, id * 4 + 1, (id + 1) * 4 + 3)

                # 处理格子内部的情况
                if grid[i][j] == '/':
                    self.merge(p, id * 4 + 0, id * 4 + 3)  # 上、左
                    self.merge(p, id * 4 + 1, id * 4 + 2)  # 右、下
                elif grid[i][j] == '\\':
                    self.merge(p, id * 4 + 0, id * 4 + 1)  # 上、右
                    self.merge(p, id * 4 + 2, id * 4 + 3)  # 下、左
                else:
                    self.merge(p, id * 4 + 0, id * 4 + 1)  # 上、右
                    self.merge(p, id * 4 + 1, id * 4 + 2)  # 右、下
                    self.merge(p, id * 4 + 2, id * 4 + 3)  # 下、左
        return self.cnt

    def merge(self, p, a, b):
        a = self.find(p, a); b = self.find(p, b)
        if a != b:
            p[a] = b
            self.cnt -= 1

    def find(self, p, x):
        if p[x] != x:
            p[x] = self.find(p, p[x])
        return p[x]


if __name__ == "__main__":
    pass
