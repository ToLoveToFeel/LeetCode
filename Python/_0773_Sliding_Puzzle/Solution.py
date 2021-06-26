# coding=utf-8
# Date: 2021/6/26 11:36
from typing import List


# 执行用时：68 ms, 在所有 Python3 提交中击败了35.33%的用户
# 内存消耗：15.2 MB, 在所有 Python3 提交中击败了5.00%的用户
class Solution:
    def slidingPuzzle(self, board: List[List[int]]) -> int:
        end = ((1, 2, 3), (4, 5, 0))
        q = [tuple(tuple(e) for e in board)]
        dist = {tuple([tuple(e) for e in board]): 0}
        dx = [-1, 0, 1, 0]; dy = [0, 1, 0, -1]
        while len(q) != 0:
            t = q[0]
            q.pop(0)

            if t == end:
                return dist[t]

            x = 0; y = 0
            for i in range(2):
                for j in range(3):
                    if t[i][j] == 0:
                        x = i; y = j
            for i in range(4):
                a = x + dx[i]; b = y + dy[i]
                if 0 <= a < 2 and 0 <= b < 3:
                    r = list(list(e) for e in t)  # 二维tuple转二维list
                    r[a][b], r[x][y] = r[x][y], r[a][b]
                    tr = tuple(tuple(e) for e in r)  # 二维list转二维tuple
                    if tr not in dist:
                        dist[tr] = dist[t] + 1
                        q.append(tr)
        return -1


if __name__ == "__main__":
    print(Solution().slidingPuzzle([[4, 1, 2], [5, 0, 3]]))  # 5
