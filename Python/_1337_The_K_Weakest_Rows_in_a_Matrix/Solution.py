# coding=utf-8
# Date: 2021/8/1 10:18
from typing import List


# 执行用时：36 ms, 在所有 Python3 提交中击败了88.52%的用户
# 内存消耗：15.2 MB, 在所有 Python3 提交中击败了22.62%的用户
class Solution:
    def kWeakestRows(self, mat: List[List[int]], k: int) -> List[int]:
        row = []
        n, m = len(mat), len(mat[0])
        for i in range(n):
            s = 0
            for j in range(m):
                s += mat[i][j]
            row.append([s, i])
        row.sort()

        res = []
        for i in range(k):
            res.append(row[i][1])
        return res


if __name__ == "__main__":
    mat = [
        [1, 1, 0, 0, 0],
        [1, 1, 1, 1, 0],
        [1, 0, 0, 0, 0],
        [1, 1, 0, 0, 0],
        [1, 1, 1, 1, 1]
    ]
    print(Solution().kWeakestRows(mat, 3))  # [2, 0, 3]
