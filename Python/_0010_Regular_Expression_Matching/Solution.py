# coding=utf-8


# 执行用时：52 ms, 在所有 Python3 提交中击败了89.96%的用户
# 内存消耗：15 MB, 在所有 Python3 提交中击败了36.85%的用户
class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        n = len(s); m = len(p)
        s = " " + s; p = " " + p
        f = [[False for _ in range(m + 1)] for _ in range(n + 1)]
        f[0][0] = True
        for i in range(n + 1):
            for j in range(1, m + 1):
                if j + 1 <= m and p[j + 1] == '*':
                    continue
                if i != 0 and p[j] != '*':
                    f[i][j] = f[i - 1][j - 1] and (s[i] == p[j] or p[j] == '.')
                elif p[j] == '*':
                    f[i][j] = f[i][j - 2] or (i > 0 and f[i - 1][j] and (s[i] == p[j - 1] or p[j - 1] == '.'))
        return f[n][m]


if __name__ == "__main__":
    print(Solution().isMatch("aa", "a"))  # False
