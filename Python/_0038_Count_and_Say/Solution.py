# coding=utf-8
# Date: 2021/5/22 10:27
from typing import List


# 执行用时：64 ms, 在所有 Python3 提交中击败了39.46%的用户
# 内存消耗：14.9 MB, 在所有 Python3 提交中击败了71.18%的用户
class Solution:
    def countAndSay(self, n: int) -> str:
        s = "1"
        for i in range(n - 1):
            t = ""
            j = 0
            while j < len(s):
                k = j + 1
                while k < len(s) and s[k] == s[j]:
                    k += 1
                t += str(k - j) + str(s[j])
                j = k
            s = t
        return s


if __name__ == "__main__":
    print(Solution().countAndSay(1))  # 1
    print(Solution().countAndSay(2))  # 11
    print(Solution().countAndSay(3))  # 21
