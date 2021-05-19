# coding=utf-8

# 执行用时：40 ms, 在所有 Python3 提交中击败了86.11%的用户
# 内存消耗：15 MB, 在所有 Python3 提交中击败了18.43%的用户
class Solution:
    def myAtoi(self, s: str) -> int:
        k = 0
        while k < len(s) and s[k] == ' ':
            k += 1
        if k == len(s):
            return 0

        minus = 1
        if s[k] == '-':
            minus = -1
            k += 1
        elif s[k] == '+':
            k += 1

        res = 0
        while k < len(s) and '0' <= s[k] <= '9':
            x = ord(s[k]) - ord('0')
            if minus > 0 and res > (pow(2, 31) - 1 - x) / 10:
                return pow(2, 31) - 1
            if minus < 0 and -res < (-pow(2, 31) + x) / 10:
                return -int(pow(2, 31))
            res = res * 10 + x
            k += 1
        return minus * res


if __name__ == "__main__":
    print(Solution().myAtoi("42"))
