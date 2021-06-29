# coding=utf-8
# Date: 2021/6/29 14:27


# 执行用时：32 ms, 在所有 Python3 提交中击败了97.89%的用户
# 内存消耗：14.9 MB, 在所有 Python3 提交中击败了56.53%的用户
class Solution:
    def titleToNumber(self, s: str) -> int:
        res = 0
        for c in s:
            res = res * 26 + (ord(c) - ord('A') + 1)
        return res


if __name__ == "__main__":
    print(Solution().titleToNumber("A"))  # 1
    print(Solution().titleToNumber("AB"))  # 28
    print(Solution().titleToNumber("ZY"))  # 701
