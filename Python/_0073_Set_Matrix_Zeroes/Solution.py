# coding=utf-8
# Date: 2021/5/26 16:55
from typing import List


class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        n = len(matrix);
        m = len(matrix[0])
        r0 = False;
        c0 = False
        for i in range(m):
            if matrix[0][i] == 0:
                r0 = True
                break
        for i in range(n):
            if matrix[i][0] == 0:
                c0 = True
                break

        for i in range(1, n):
            for j in range(m):
                if matrix[i][j] == 0:
                    matrix[i][0] = 0
                    break
        for i in range(1, m):
            for j in range(n):
                if matrix[j][i] == 0:
                    matrix[0][i] = 0
                    break

        for i in range(1, n):
            if matrix[i][0] == 0:
                for j in range(1, m):
                    matrix[i][j] = 0
        for i in range(1, m):
            if matrix[0][i] == 0:
                for j in range(n):
                    matrix[j][i] = 0
        if r0:
            for i in range(m):
                matrix[0][i] = 0
        if c0:
            for i in range(n):
                matrix[i][0] = 0


if __name__ == "__main__":
    matrix = [[1, 1, 1], [1, 0, 1], [1, 1, 1]]
    Solution().setZeroes(matrix)
    print(matrix)  # [[1, 0, 1], [0, 0, 0], [1, 0, 1]]
