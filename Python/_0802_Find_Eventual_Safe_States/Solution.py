# coding=utf-8
# Date: 2021/8/5 11:12
from typing import List


# 执行用时：156 ms, 在所有 Python3 提交中击败了61.27%的用户
# 内存消耗：19.9 MB, 在所有 Python3 提交中击败了40.46%的用户
class Solution:
    def eventualSafeNodes(self, graph: List[List[int]]) -> List[int]:
        n = len(graph)
        d = [0] * n
        g = [[] for _ in range(n)]
        for i in range(n):
            for b in graph[i]:
                a = i
                g[b].append(a)
                d[a] += 1

        q = []
        for i in range(n):
            if d[i] == 0:
                q.append(i)

        while len(q) != 0:
            t = q[0]
            q.pop(0)
            for i in g[t]:
                d[i] -= 1
                if d[i] == 0:
                    q.append(i)

        res = []
        for i in range(n):
            if d[i] == 0:
                res.append(i)
        return res


if __name__ == "__main__":
    print(Solution().eventualSafeNodes([[], [0, 2, 3, 4], [3], [4], []]))
