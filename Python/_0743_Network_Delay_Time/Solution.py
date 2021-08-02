# coding=utf-8
# Date: 2021/8/2 9:55
from typing import List


# 执行用时：104 ms, 在所有 Python3 提交中击败了54.00%的用户
# 内存消耗：16.2 MB, 在所有 Python3 提交中击败了45.89%的用户
class Solution:
    def __init__(self):
        self.N = 110
        self.INF = 0x3f3f3f3f
        self.g = [[self.INF for _ in range(self.N)] for _ in range(self.N)]
        self.dist = [self.INF for _ in range(self.N)]
        self.st = [False for _ in range(self.N)]

    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        for e in times:
            self.g[e[0]][e[1]] = e[2]
        return self.dijkstra(k, n)

    def dijkstra(self, start, n):
        self.dist[start] = 0

        for i in range(n):
            t = -1
            for j in range(1, n + 1):
                if not self.st[j] and (t == -1 or self.dist[j] < self.dist[t]):
                    t = j

            self.st[t] = True

            for j in range(1, n + 1):
                self.dist[j] = min(self.dist[j], self.dist[t] + self.g[t][j])

        res = 0
        for i in range(1, n + 1):
            res = max(res, self.dist[i])

        if res == self.INF:
            res = -1
        return res


if __name__ == "__main__":
    print(Solution().networkDelayTime([[2, 1, 1], [2, 3, 1], [3, 4, 1]], 4, 2))  # 2
