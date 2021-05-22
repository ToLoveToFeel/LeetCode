# coding=utf-8
# Date: 2021/5/22 11:46


# 执行用时：684 ms, 在所有 Python3 提交中击败了78.08%的用户
# 内存消耗：23.2 MB, 在所有 Python3 提交中击败了28.39%的用户
class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        n = len(s); m = len(p)
        s = " " + s; p = ' ' + p
        f = [[False for _ in range(m + 1)] for _ in range(n + 1)]
        f[0][0] = True
        for i in range(n + 1):  # f[0][j]是有意义的，例如p="***"，因此i从0开始
            for j in range(1, m + 1):  # f[i][0] (i>0)是没有意义的，因此j从1开始
                if p[j] != '*':
                    f[i][j] = (s[i] == p[j] or p[j] == '?') and i > 0 and f[i - 1][j - 1]
                else:
                    f[i][j] = f[i][j - 1] or (i > 0 and f[i - 1][j])
        return f[n][m]


if __name__ == "__main__":
    print(Solution().isMatch("aa", "a"))  # False
