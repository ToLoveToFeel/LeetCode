# coding=utf-8
# Date: 2021/8/15 10:23

# 执行用时：392 ms, 在所有 Python3 提交中击败了15.57%的用户
# 内存消耗：18.9 MB, 在所有 Python3 提交中击败了61.25%的用户
class Solution:
    def findPaths(self, m: int, n: int, maxMove: int, x: int, y: int) -> int:
        MOD = int(1e9) + 7
        if maxMove == 0:
            return 0

        f = [[[0 for _ in range(maxMove + 1)] for _ in range(n)] for _ in range(m)]

        for i in range(n):
            f[0][i][1] += 1
            f[m - 1][i][1] += 1
        for i in range(m):
            f[i][0][1] += 1
            f[i][n - 1][1] += 1

        dx, dy = [-1, 0, 1, 0], [0, 1, 0, -1]
        for k in range(1, maxMove + 1):
            for i in range(m):
                for j in range(n):
                    for u in range(4):
                        a, b = i + dx[u], j + dy[u]
                        if a >= 0 and a < m and b >= 0 and b < n:
                            f[i][j][k] = (f[i][j][k] + f[a][b][k - 1]) % MOD

        res = 0
        for k in range(maxMove + 1):
            res = (res + f[x][y][k]) % MOD

        return res


if __name__ == "__main__":
    print(Solution().findPaths(2, 2, 2, 0, 0))  # 6
