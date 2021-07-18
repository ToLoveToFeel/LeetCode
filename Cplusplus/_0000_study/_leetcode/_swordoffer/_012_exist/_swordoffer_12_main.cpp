// Created by WXX on 2021/7/18 15:17
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int n, m;
    int dx[4] = {-1, 0, 1, 0}, dy[4] = {0, 1, 0, -1};
    vector<vector<bool>> st;

    bool exist(vector<vector<char>> &board, string word) {
        n = board.size();
        m = board[0].size();
        st = vector<vector<bool>>(n, vector<bool>(m));
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (dfs(board, i, j, word, 0))
                    return true;
        return false;
    }

    bool dfs(vector<vector<char>> &board, int x, int y, string &word, int u) {

        if (board[x][y] != word[u]) return false;
        if (u == word.size() - 1) return true;

        st[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int a = x + dx[i], b = y + dy[i];
            if (a >= 0 && a < n && b >= 0 && b < m && !st[a][b]) {
                if (dfs(board, a, b, word, u + 1))
                    return true;
            }
        }
        st[x][y] = false;
        return false;
    }
};

int main() {

    vector<vector<char>> board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'},
    };
    cout << Solution().exist(board, "ABCCED") << endl;  // true

    return 0;
}
