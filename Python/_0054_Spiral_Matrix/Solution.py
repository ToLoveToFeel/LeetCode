# coding=utf-8
from typing import List


# 执行用时：40 ms, 在所有 Python3 提交中击败了60.05%的用户
# 内存消耗：14.8 MB, 在所有 Python3 提交中击败了80.38%的用户
class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        n = len(matrix); m = len(matrix[0])
        dx = [0, 1, 0, -1]; dy = [1, 0, -1, 0]
        st = [[False for _ in range(m)] for _ in range(n)]

        res = []
        x = y = d = 0
        for i in range(n * m):
            res.append(matrix[x][y])
            st[x][y] = True
            a = x + dx[d]; b = y + dy[d]
            if a < 0 or a >= n or b < 0 or b >= m or st[a][b]:
                d = (d + 1) % 4
                a = x + dx[d]; b = y + dy[d]
            x = a; y = b
        return res


if __name__ == "__main__":
    matrix = [
        [1, 2, 3],
        [4, 5, 6],
        [7, 8, 9]
    ]
    print(Solution().spiralOrder(matrix))


# class Solution(object):
#     def spiralOrder(self, matrix):
#         """
#         :type matrix: List[List[int]]
#         :rtype: List[int]
#         """
#         res = []
#
#         while matrix:
#             res.extend(matrix.pop(0))
#             matrix = list(map(list, zip(*matrix)))[::-1]
#             print(matrix)
#             if not matrix or not matrix[0]:
#                 break
#         return res