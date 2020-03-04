# coding=utf-8
# 螺旋矩阵


class Solution(object):
    """
        1、对于这个列表矩阵，先输出第一行并将其pop除去，然后将矩阵逆时针旋转90度，
           继续输出第一行并将其pop出去，递归的执行上述操作直至矩阵为空。
    """
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


if __name__ == "__main__":
    matrix = [
        [1, 2, 3],
        [4, 5, 6],
        [7, 8, 9]
    ]
    So = Solution()
    print(So.spiralOrder(matrix))


