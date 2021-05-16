# coding=utf-8

class Solution(object):
    """
        1、这道题比较巧妙，顺时针转90度可以转换为 先上下翻转，再对角线翻转;
        2、同理：逆时针转90度可以转换为 先左右翻转，再对角线翻转.
    """
    def rotate(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: None Do not return anything, modify matrix in-place instead.
        """
        # return list(map(list, zip(*matrix)))[::-1]  # 逆时针旋转90度
        # return list(map(list, zip(*matrix[::-1])))  # 顺时针旋转90度
        for i in range(int(len(matrix)/2)):
            temp = matrix[i]
            matrix[i] = matrix[len(matrix)-1-i]
            matrix[len(matrix) - 1 - i] = temp

        for index, row in enumerate(matrix):
            for col in range(index, len(row)):
                temp = matrix[index][col]
                matrix[index][col] = matrix[col][index]
                matrix[col][index] = temp
        return matrix


if __name__ == "__main__":
    matrix = [
        [1, 2, 3],
        [4, 5, 6],
        [7, 8, 9]
    ]
    So = Solution()
    print(So.rotate(matrix))


