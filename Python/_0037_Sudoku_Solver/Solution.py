# coding=utf-8
# Date: 2021/5/22 10:19
from typing import List


# 执行用时：132 ms, 在所有 Python3 提交中击败了69.98%的用户
# 内存消耗：15.1 MB, 在所有 Python3 提交中击败了47.61%的用户
class Solution:
    def solveSudoku(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        row = [[False for _ in range(9)] for _ in range(9)]
        col = [[False for _ in range(9)] for _ in range(9)]
        box = [[[False for _ in range(9)] for _ in range(3)] for _ in range(3)]
        for i in range(9):
            for j in range(9):
                if board[i][j] != '.':
                    t = ord(board[i][j]) - ord('1')
                    row[i][t] = col[j][t] = box[i // 3][j // 3][t] = True
        self.dfs(board, 0, 0, row, col, box)

    def dfs(self, board, x, y, row, col, box):
        if y == 9:
            x += 1
            y = 0
        if x == 9:
            return True

        if board[x][y] != '.':
            return self.dfs(board, x, y + 1, row, col, box)
        for i in range(9):
            if not row[x][i] and not col[y][i] and not box[x // 3][y // 3][i]:
                board[x][y] = chr(ord('1') + i)
                row[x][i] = col[y][i] = box[x // 3][y // 3][i] = True
                if self.dfs(board, x, y + 1, row, col, box):
                    return True
                row[x][i] = col[y][i] = box[x // 3][y // 3][i] = False
                board[x][y] = '.'
        return False


if __name__ == "__main__":
    board = [
        ["5", "3", ".", ".", "7", ".", ".", ".", "."],
        ["6", ".", ".", "1", "9", "5", ".", ".", "."],
        [".", "9", "8", ".", ".", ".", ".", "6", "."],
        ["8", ".", ".", ".", "6", ".", ".", ".", "3"],
        ["4", ".", ".", "8", ".", "3", ".", ".", "1"],
        ["7", ".", ".", ".", "2", ".", ".", ".", "6"],
        [".", "6", ".", ".", ".", ".", "2", "8", "."],
        [".", ".", ".", "4", "1", "9", ".", ".", "5"],
        [".", ".", ".", ".", "8", ".", ".", "7", "9"]
    ]
    Solution().solveSudoku(board)
    print(board)
