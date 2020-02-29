# coding=utf-8


class Solution(object):
    def spiralOrder(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[int]
        """
        ret = []

        while matrix:
            ret.extend(matrix.pop(0))
            matrix = list(map(list, zip(*matrix)))[::-1]
            if not matrix or not matrix[0]:
                break
        return ret


matrix = [
            [1, 2, 3],
            [4, 5, 6],
            [7, 8, 9]
         ]

print(Solution().spiralOrder(matrix))


