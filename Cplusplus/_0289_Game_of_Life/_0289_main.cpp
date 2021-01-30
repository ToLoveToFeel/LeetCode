// Created by WXX on 2021/1/30 19:58
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    void gameOfLife(vector<vector<int>> &board) {

        int n = board.size(), m = board[0].size();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                int live = 0;
                for (int x = max(0, i - 1); x <= min(n - 1, i + 1); x++)
                    for (int y = max(0, j - 1); y <= min(m - 1, j + 1); y++)
                        if ((x != i || y != j) && (board[x][y] & 1))
                            live++;
                int cur = board[i][j] & 1, next;
                if (cur) {  // 当前考察的细胞是活细胞
                    if (live < 2 || live > 3) next = 0;
                    else next = 1;
                } else {  // 当前考察的细胞是死细胞
                    if (live == 3) next = 1;
                    else next = 0;
                }
                board[i][j] |= (next << 1);
            }

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                board[i][j] >>= 1;
    }
};

void OutputBasicArray2D(vector<vector<int>> &nums) {

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

    vector<vector<int>> board = {
            {0, 1, 0},
            {0, 0, 1},
            {1, 1, 1},
            {0, 0, 0}
    };
    Solution().gameOfLife(board);
    OutputBasicArray2D(board);

    return 0;
}
