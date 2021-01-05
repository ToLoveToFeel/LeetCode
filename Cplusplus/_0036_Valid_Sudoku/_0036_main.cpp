#include <cstring>
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：32 ms, 在所有 C++ 提交中击败了85.62%的用户
 * 内存消耗：17.9 MB, 在所有 C++ 提交中击败了81.74%的用户
 */
class Solution {
public:
    bool isValidSudoku(vector<vector<char>> &board) {

        bool st[9];

        // 判断行
        for (int i = 0; i < 9; i++) {
            memset(st, 0, sizeof(st));
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] != '.') {
                    int t = board[i][j] - '1';
                    if (st[t]) return false;
                    st[t] = true;
                }
            }
        }

        // 判断列
        for (int i = 0; i < 9; i++) {
            memset(st, 0, sizeof(st));
            for (int j = 0; j < 9; ++j) {
                if (board[j][i] != '.') {
                    int t = board[j][i] - '1';
                    if (st[t]) return false;
                    st[t] = true;
                }
            }
        }

        // 判断小方格
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                memset(st, 0, sizeof(st));
                for (int x = 0; x < 3; ++x) {
                    for (int y = 0; y < 3; ++y) {
                        if (board[i + x][j + y] != '.') {
                            int t = board[i + x][j + y] - '1';
                            if (st[t]) return false;
                            st[t] = true;
                        }
                    }
                }
            }
        }

        return true;
    }
};

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
    cout << Solution().isValidSudoku(board);  // true

    return 0;
}