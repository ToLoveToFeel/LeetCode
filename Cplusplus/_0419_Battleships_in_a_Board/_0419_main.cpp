// Created by WXX on 2021/5/31 21:24
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：8 ms, 在所有 C++ 提交中击败了59.32%的用户
 * 内存消耗：7.8 MB, 在所有 C++ 提交中击败了40.32%的用户
 */
class Solution {
public:
    int countBattleships(vector<vector<char>> &board) {
        int res = 0;
        for (int i = 0; i < board.size(); i++)
            for (int j = 0; j < board[i].size(); j++) {
                if (i > 0 && board[i - 1][j] == 'X') continue;
                if (j > 0 && board[i][j - 1] == 'X') continue;
                if (board[i][j] == 'X') res++;
            }
        return res;
    }
};

int main() {

    vector<vector<char>> board = {
            {'X', '.', '.', 'X'},
            {'.', '.', '.', 'X'},
            {'.', '.', '.', 'X'},
    };
    cout << Solution().countBattleships(board) << endl;  // 2

    return 0;
}
