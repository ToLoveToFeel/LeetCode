# coding=utf-8
# Date: 2021/6/29 14:12


# 执行用时：44 ms, 在所有 Python3 提交中击败了28.01%的用户
# 内存消耗：14.9 MB, 在所有 Python3 提交中击败了33.07%的用户
class Solution:
    def convertToTitle(self, n: int) -> str:
        res = ""
        while n != 0:
            n -= 1
            res += chr(n % 26 + ord('A'))
            n //= 26
        return res[::-1]


if __name__ == "__main__":
    print(Solution().convertToTitle(1))  # A
    print(Solution().convertToTitle(701))  # ZY
