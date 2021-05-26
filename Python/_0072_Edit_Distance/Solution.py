# coding=utf-8
# Date: 2021/5/26 16:54


class Solution:
    def minDistance(self, a: str, b: str) -> int:
        n = len(a); m = len(b)
        a = " " + a; b = " " + b
        f = [[0 for _ in range(m + 1)] for _ in range(n + 1)]
        for j in range(m + 1):
            f[0][j] = j
        for i in range(n + 1):
            f[i][0] = i
        for i in range(1, n + 1):
            for j in range(1, m + 1):
                f[i][j] = min(f[i - 1][j] + 1, f[i][j - 1] + 1)
                if a[i] == b[j]:
                    f[i][j] = min(f[i][j], f[i - 1][j - 1])
                else:
                    f[i][j] = min(f[i][j], f[i - 1][j - 1] + 1)
        return f[n][m]


if __name__ == "__main__":
    print(Solution().minDistance("horse", "ros"))  # 3
