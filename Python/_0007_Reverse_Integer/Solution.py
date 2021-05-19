# coding=utf-8


# 执行用时：40 ms, 在所有 Python3 提交中击败了77.59%的用户
# 内存消耗：14.9 MB, 在所有 Python3 提交中击败了31.41%的用户
class Solution:
    def reverse(self, x: int) -> int:
        r = 0
        sign = 1  # 记录符号，统一转为正数处理
        if x < 0:
            sign = -1
            x = -x

        while x != 0:
            r = r * 10 + x % 10
            x //= 10

        r *= sign
        if sign == 1:
            if r > pow(2, 31) - 1:
                r = 0
        else:
            if r < -pow(2, 31):
                r = 0
        return r


if __name__ == "__main__":
    print(Solution().reverse(-123))
    print(Solution().reverse(1534236469))
