# coding=utf-8
# Date: 2021/5/26 16:57
from typing import List


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        n = len(matrix); m = len(matrix[0])
        l = 0; r = n * m - 1
        while l < r:
            mid = (l + r) // 2
            if matrix[mid // m][mid % m] >= target:
                r = mid
            else:
                l = mid + 1
        return matrix[r // m][r % m] == target


if __name__ == "__main__":
    print(Solution().searchMatrix([[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]], 3))
