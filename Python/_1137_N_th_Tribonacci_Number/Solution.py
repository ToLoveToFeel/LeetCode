# coding=utf-8
# Date: 2021/8/8 11:26


# 执行用时：32 ms, 在所有 Python3 提交中击败了72.08%的用户
# 内存消耗：14.9 MB, 在所有 Python3 提交中击败了40.24%的用户
class Solution:
    def tribonacci(self, n: int) -> int:
        if n == 0:
            return 0
        if n <= 2:
            return 1
        a, b, c, d = 0, 1, 1, 2
        for i in range(n - 2):
            d = a + b + c
            a, b, c = b, c, d
        return d


if __name__ == "__main__":
    print(Solution().tribonacci(4))  # 4
    print(Solution().tribonacci(25))  # 1389537
