# coding=utf-8
from typing import List


# 执行用时：40 ms, 在所有 Python3 提交中击败了61.26%的用户
# 内存消耗：14.9 MB, 在所有 Python3 提交中击败了37.08%的用户
class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        n = len(matrix)
        for i in range(0, n):
            j = 0; k = n - 1
            while j < k:
                matrix[j][i], matrix[k][i] = matrix[k][i], matrix[j][i]
                j += 1; k -= 1
        for i in range(0, n):
            for j in range(0, i):
                matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]


if __name__ == "__main__":
    matrix = [
        [1, 2, 3],
        [4, 5, 6],
        [7, 8, 9]
    ]
    Solution().rotate(matrix)
    print(matrix)
