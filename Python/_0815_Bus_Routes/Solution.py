# coding=utf-8
# Date: 2021/6/28 10:30
from typing import List


# 执行用时：148 ms, 在所有 Python3 提交中击败了90.31%的用户
# 内存消耗：34.6 MB, 在所有 Python3 提交中击败了28.32%的用户
class Solution:
    def numBusesToDestination(self, routes: List[List[int]], source: int, target: int) -> int:
        if source == target:
            return 0
        n = len(routes)
        g = {}
        dist = [(int)(1e8) for _ in range(n)]
        q = []
        for i in range(n):
            for x in routes[i]:
                if x == source:
                    dist[i] = 1
                    q.append(i)
                if x not in g:
                    g[x] = []
                g[x].append(i)

        while len(q) != 0:
            t = q[0]
            q.pop(0)

            for x in routes[t]:
                if x == target:
                    return dist[t]
                if x not in g:
                    continue
                for y in g[x]:
                    if dist[y] > dist[t] + 1:
                        dist[y] = dist[t] + 1
                        q.append(y)
                del g[x]
        return -1


if __name__ == "__main__":
    print(Solution().numBusesToDestination([[1, 2, 7], [3, 6, 7]], 1, 6))  # 2
