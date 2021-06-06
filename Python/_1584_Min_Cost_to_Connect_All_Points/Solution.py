# coding=utf-8
# Date: 2021/6/6 16:45
from typing import List


# 执行用时：1580 ms, 在所有 Python3 提交中击败了66.67%的用户
# 内存消耗：38.6 MB, 在所有 Python3 提交中击败了84.93%的用户
class Solution:
    def minCostConnectPoints(self, points: List[List[int]]) -> int:

        INF = 0x3f3f3f3f
        n = len(points)
        g = [[INF for _ in range(n)] for _ in range(n)]
        for i in range(n):
            for j in range(i):
                p1 = points[i]; p2 = points[j]
                g[i][j] = g[j][i] = abs(p1[0] - p2[0]) + abs(p1[1] - p2[1])

        dist = [INF for _ in range(n)]
        st = [False for _ in range(n)]
        res = 0
        for i in range(n):
            t = -1
            for j in range(n):
                if not st[j] and (t == -1 or dist[t] > dist[j]):
                    t = j

            if i != 0:
                res += dist[t]
            st[t] = True
            for j in range(n):
                dist[j] = min(dist[j], g[t][j])
        return res


if __name__ == "__main__":
    points = [[0, 0], [2, 2], [3, 10], [5, 2], [7, 0]]
    print(Solution().minCostConnectPoints(points))  # 20
