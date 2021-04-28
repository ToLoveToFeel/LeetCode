// Created by WXX on 2021/4/28 11:32
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：172 ms, 在所有 C++ 提交中击败了5.55%的用户
 * 内存消耗：136.7 MB, 在所有 C++ 提交中击败了5.02%的用户
 */
class Solution {
public:
    vector<vector<bool>> st;
    int n, m;  // 行数、列数
    int dx[4] = {-1, 0, 1, 0}, dy[4] = {0, 1, 0, -1};

    void solve(vector<vector<char>> &board) {
        n = board.size(), m = board[0].size();
        st = vector<vector<bool>>(n, vector<bool>(m, false));

        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') dfs(board, i, 0);
            if (board[i][m - 1] == 'O') dfs(board, i, m - 1);
        }
        for (int i = 0; i < m; i++) {
            if (board[0][i] == 'O') dfs(board, 0, i);
            if (board[n - 1][i] == 'O') dfs(board, n - 1, i);
        }

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (!st[i][j])
                    board[i][j] = 'X';
    }

    void dfs(vector<vector<char>> board, int x, int y) {
        st[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int a = x + dx[i], b = y + dy[i];
            if (a >= 0 && a < n && b >= 0 && b < m && !st[a][b] && board[a][b] == 'O')
                dfs(board, a, b);
        }
    }
};

void OutputBasicArray2D(vector<vector<char>> nums) {

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
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'},
    };
    Solution().solve(board);
    OutputBasicArray2D(board);

    return 0;
}
