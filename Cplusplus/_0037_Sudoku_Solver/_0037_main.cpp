#include <cstring>
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：4 ms, 在所有 C++ 提交中击败了93.94%的用户
 * 内存消耗：6.8 MB, 在所有 C++ 提交中击败了47.82%的用户
 */
class Solution {
public:

    bool row[9][9], col[9][9], cell[3][3][9];

    void solveSudoku(vector<vector<char>> &board) {
        memset(row, 0, sizeof(row));
        memset(col, 0, sizeof(col));
        memset(cell, 0, sizeof(cell));

        for (int i = 0; i < 9; ++i)
            for (int j = 0; j < 9; ++j)
                if (board[i][j] != '.') {
                    int t = board[i][j] - '1';
                    row[i][t] = col[j][t] = cell[i / 3][j / 3][t] = true;
                }
        dfs(board, 0, 0);
    }

    bool dfs(vector<vector<char>> &board, int x, int y) {
        if (y == 9) x++, y = 0;
        if (x == 9) return true;

        if (board[x][y] != '.') return dfs(board, x, y + 1);
        for (int i = 0; i < 9; ++i) {
            if (!row[x][i] && !col[y][i] && !cell[x / 3][y / 3][i]) {
                board[x][y] = '1' + i;
                row[x][i] = col[y][i] = cell[x / 3][y / 3][i] = true;
                if (dfs(board, x, y + 1)) return true;
                board[x][y] = '.';
                row[x][i] = col[y][i] = cell[x / 3][y / 3][i] = false;
            }
        }
        return false;
    }
};

void OutputBasicArray2D(vector<vector<char>> &nums) {

    cout << "[";
    for (int i = 0; i < nums.size(); i++) {
        if (i > 0 && i < nums.size()) cout << ' ';
        cout << "[";
        for (int j = 0; j < nums[i].size(); j++) {
            cout << nums[i][j];
            if (j != nums[i].size() - 1) cout << ", ";
        }
        cout << "]";
        if (i != nums.size() - 1) cout << ", " << endl;
    }
    cout << "]" << endl;
}

int main() {

    vector<vector<char>> board = {
            {'.', '9', '.', '.', '4', '.', '.', '.', '.'},
            {'1', '.', '.', '.', '.', '.', '6', '.', '.'},
            {'.', '.', '3', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '7', '.', '.', '.', '.', '.'},
            {'3', '.', '.', '.', '5', '.', '.', '.', '.'},
            {'.', '.', '7', '.', '.', '4', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '7', '.', '.', '.', '.'}
    };
    Solution().solveSudoku(board);
    OutputBasicArray2D(board);

    return 0;
}