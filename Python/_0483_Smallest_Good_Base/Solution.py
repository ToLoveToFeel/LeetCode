# coding=utf-8
# Date: 2021/6/18 17:35
import math


# 执行用时：44 ms, 在所有 Python3 提交中击败了90.00%的用户
# 内存消耗：14.9 MB, 在所有 Python3 提交中击败了20.00%的用户
class Solution:
    def smallestGoodBase(self, n: str) -> str:
        N = int(n)
        t = int(math.log2(N) + 1)
        while t >= 3:
            k = int(pow(N, 1.0 / (t - 1)))
            r = 0
            for i in range(t):
                r = r * k + 1
            if r == N:
                return str(k)
            t -= 1
        return str(N - 1)


if __name__ == "__main__":
    print(Solution().smallestGoodBase("13"))  # 3
