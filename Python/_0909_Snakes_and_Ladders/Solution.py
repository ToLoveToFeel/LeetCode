# coding=utf-8
# Date: 2021/6/27 15:23
from typing import List


# 执行用时：112 ms, 在所有 Python3 提交中击败了97.25%的用户
# 内存消耗：15.3 MB, 在所有 Python3 提交中击败了7.34%的用户
class Solution:
    def snakesAndLadders(self, board: List[List[int]]) -> int:
        n = len(board)
        id = [[0 for _ in range(n)] for _ in range(n)]
        cor = [[0, 0] for _ in range(n * n + 1)]
        k = 1; s = 0
        for i in range(n - 1, -1, -1):
            if s % 2 == 0:
                for j in range(n):
                    id[i][j] = k
                    cor[k] = [i, j]
                    k += 1
            else:
                for j in range(n - 1, -1, -1):
                    id[i][j] = k
                    cor[k] = [i, j]
                    k += 1
            s += 1

        q = [[n - 1, 0]]
        dist = [[(int) (1e9) for _ in range(n)] for _ in range(n)]
        dist[n - 1][0] = 0
        while len(q) != 0:
            t = q[0]
            q.pop(0)

            k = id[t[0]][t[1]]
            if k == n * n:
                return dist[t[0]][t[1]]
            for i in range(k + 1, min(k + 6, n * n) + 1):
                x = cor[i][0]; y = cor[i][1]
                if board[x][y] != -1:
                    r = board[x][y]
                    x = cor[r][0]; y = cor[r][1]
                if dist[x][y] > dist[t[0]][t[1]] + 1:
                    dist[x][y] = dist[t[0]][t[1]] + 1
                    q.append([x, y])
        return -1


if __name__ == "__main__":
    board = [
        [-1, -1, -1, -1, -1, -1],
        [-1, -1, -1, -1, -1, -1],
        [-1, -1, -1, -1, -1, -1],
        [-1, 35, -1, -1, 13, -1],
        [-1, -1, -1, -1, -1, -1],
        [-1, 15, -1, -1, -1, -1]
    ]
    print(Solution().snakesAndLadders(board))  # 4
