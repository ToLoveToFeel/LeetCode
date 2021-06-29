# coding=utf-8
# Date: 2021/6/29 14:38


# 执行用时：48 ms, 在所有 Python3 提交中击败了43.99%的用户
# 内存消耗：15.1 MB, 在所有 Python3 提交中击败了5.51%的用户
class Solution:
    def trailingZeroes(self, n: int) -> int:
        res = 0
        while n != 0:
            res += n // 5
            n //= 5
        return res


if __name__ == "__main__":
    pass
