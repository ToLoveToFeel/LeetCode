# coding=utf-8
# Date: 2021/8/12 09:49


# 执行用时：4016 ms, 在所有 Python3 提交中击败了5.01%的用户
# 内存消耗：31.8 MB, 在所有 Python3 提交中击败了24.70%的用户
class Solution:
    def longestPalindromeSubseq(self, s: str) -> int:
        n = len(s)
        f = [[0 for _ in range(n)] for _ in range(n)]
        for length in range(1, n + 1):
            for i in range(n - (length - 1)):
                j = i + length - 1
                if length == 1:
                    f[i][j] = 1
                else:
                    if s[i] == s[j]:
                        f[i][j] = f[i + 1][j - 1] + 2
                    f[i][j] = max(f[i][j], max(f[i][j - 1], f[i + 1][j]))
        return f[0][n - 1]


if __name__ == "__main__":
    print(Solution().longestPalindromeSubseq("bbbab"))  # 4
    print(Solution().longestPalindromeSubseq("cbbd"))  # 2
