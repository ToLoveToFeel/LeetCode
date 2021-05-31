# coding=utf-8
# Date: 2021/5/31 8:50


# 执行用时：36 ms, 在所有 Python3 提交中击败了89.43%的用户
# 内存消耗：14.7 MB, 在所有 Python3 提交中击败了79.74%的用户
class Solution:
    def isPowerOfFour(self, n: int) -> bool:
        if n <= 0:
            return False
        r = int(n ** 0.5)
        if r * r != n:
            return False
        return (1 << 30) % n == 0


if __name__ == "__main__":
    print(Solution().isPowerOfFour(16))  # True
    print(Solution().isPowerOfFour(8))  # False
