# coding=utf-8
# Date: 2021/7/17 15:57


# 执行用时：108 ms, 在所有 Python3 提交中击败了93.09%的用户
# 内存消耗：15 MB, 在所有 Python3 提交中击败了60.56%的用户
class Solution:
    def countSubstrings(self, s: str) -> int:
        n = len(s)
        res = 0
        for i in range(n):
            j, k = i, i
            while j >= 0 and k < n and s[j] == s[k]:
                res += 1
                j -= 1
                k += 1
            j, k = i, i + 1
            while j >= 0 and k < n and s[j] == s[k]:
                res += 1
                j -= 1
                k += 1
        return res


if __name__ == "__main__":
    print(Solution().countSubstrings("abc"))  # 3
