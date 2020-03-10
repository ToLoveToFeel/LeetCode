# coding=utf-8
# @Time       : 2020/3/9
# @Author     : Wang Xiaoxiao
# @University : Dalian University of Technology
# @FileName   : Solution2.py
# @Software   : PyCharm
# @github     : https://github.com/i-love-linux/LeetCode
# 二进制加和


class Solution(object):
    def addBinary(self, a, b):
        """
        :type a: str
        :type b: str
        :rtype: str
        """
        return bin(int(a, 2) + int(b, 2))[2:]


if __name__ == "__main__":
    a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101"
    b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"
    print(Solution().addBinary(a, b))

