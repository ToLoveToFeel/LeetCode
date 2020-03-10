# coding=utf-8
# @Time       : 2020/3/9
# @Author     : Wang Xiaoxiao
# @University : Dalian University of Technology
# @FileName   : Solution.py
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
        # 将a,b转为十进制
        a_ten = 0
        for c in a:
            a_ten = a_ten * 2 + int(c)
        b_ten = 0
        for c in b:
            b_ten = b_ten * 2 + int(c)
        # 求和
        sum = a_ten + b_ten
        if sum == 0:
            return "0"
        # 结果转化为二进制
        ret = []
        while sum:
            ret.append(str(sum%2))
            # sum = int(sum/2)
            sum = sum // 2
        return "".join(ret[::-1])


if __name__ == "__main__":
    a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101"
    b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"
    print(Solution().addBinary(a, b))













"""
针对LeetCode 67号问题，我发现一个问题：

我首先使用Java解题，思路一：a,b转为数字，然后相加，之后转为二进制字符串，提交会不通过，因为数据越界，具体越界的测试用例是：(IDE：IDEA，SDK：java version "1.8.0_231")

public static void main(String[] args) {
    String a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
    String b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
    System.out.println((new Solution()).addBinary(a, b));
}
后来我用思路二用Java完成了这个题目，提交成功通过，对于这个测试用例的结果为：

110111101100010011000101110110100000011101000101011001000011011000001100011110011010010011000000000


之后我将该思路一用python实现，代码如下：(IDE：PyChram，Interpreter：Python 3.6)

class Solution(object):
    def addBinary(self, a, b):
 
        # 将a,b转为十进制
        a_ten = 0
        for c in a:
            a_ten = a_ten * 2 + int(c)
        b_ten = 0
        for c in b:
            b_ten = b_ten * 2 + int(c)
        # 求和
        sum = a_ten + b_ten
        print("sum : ", sum)
        if sum == 0:
            return "0"
        # 结果转化为二进制
        ret = []
        while sum:
            ret.append(str(sum%2))
            sum = int(sum/2)
        return "".join(ret[::-1])
提交之后成功通过测试，对于前面的那个测试用例的输出结果为：

110111101100010011000101110110100000011101000101011010000000000000000000000000000000000000000000000
对比发现，这个结果和Java的结果不同，问题就出在这里：对于同一个测试用例，语言不同，测试结果不同，但都获得通过。



深入分析之后，我找到了问题出在了哪里：Java的那个结果是对的，Python的那个结果是错的，错误的原因在于上面Python代码中的倒数第二行，即：

                        sum = int(sum/2)
具体错误原因：这句话产生了浮点数误差。

随后我将这句话改为：

                        sum = sum // 2
​对于上面的测试用例结果就和Java的结果相同了。
"""
