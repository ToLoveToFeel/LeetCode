# coding=utf-8
# Date: 2021/5/24 17:11


# 组合数
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        f = [[0 for _ in range(n)] for _ in range(m)]
        for i in range(m):
            for j in range(n):
                if i == 0 or j == 0:
                    f[i][j] = 1
                else:
                    f[i][j] = f[i - 1][j] + f[i][j - 1]
        return f[m - 1][n - 1]


if __name__ == "__main__":
    print(Solution().uniquePaths(3, 7))  # 28
