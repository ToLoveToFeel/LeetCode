# coding=utf-8
# Date: 2021/8/6 10:34
from typing import List


# 执行用时：648 ms, 在所有 Python3 提交中击败了16.86%的用户内存消耗：16.2 MB, 在所有 Python3 提交中击败了70.93%的用户
class Solution:
    def shortestPathLength(self, graph: List[List[int]]) -> int:
        n, INF = len(graph), int(1e8)
        f = [[INF for _ in range(n)] for _ in range(1 << n)]

        q = []
        for i in range(n):
            f[1 << i][i] = 0
            q.append([1 << i, i])

        while len(q) != 0:
            t = q[0]
            q.pop(0)

            x, y = t[0], t[1]
            for z in graph[y]:
                s = x | 1 << z
                if f[s][z] > f[x][y] + 1:
                    f[s][z] = f[x][y] + 1
                    q.append([s, z])

        res = INF
        for i in range(n):
            res = min(res, f[(1 << n) - 1][i])
        return res


if __name__ == "__main__":
    print(Solution().shortestPathLength([[1, 2, 3], [0], [0], [0]]))  # 4
