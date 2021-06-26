// Created by WXX on 2021/6/26 11:14
#include <iostream>
#include <vector>
#include <map>
#include <queue>

using namespace std;

/**
 * 执行用时：64 ms, 在所有 C++ 提交中击败了6.63%的用户
 * 内存消耗：14.6 MB, 在所有 C++ 提交中击败了8.07%的用户
 */
class Solution {
public:
    int slidingPuzzle(vector<vector<int>> &board) {
        typedef vector<vector<int>> VII;
        VII end = {{1, 2, 3},
                   {4, 5, 0}};
        if (board == end) return 0;

        queue<VII> q;
        q.push(board);
        map<VII, int> dist;
        dist[board] = 0;

        int dx[4] = {-1, 0, 1, 0}, dy[4] = {0, 1, 0, -1};
        while (q.size()) {
            auto t = q.front();
            q.pop();
            int x, y;
            for (int i = 0; i < 2; i++)
                for (int j = 0; j < 3; j++)
                    if (t[i][j] == 0)
                        x = i, y = j;
            for (int i = 0; i < 4; i++) {
                int a = x + dx[i], b = y + dy[i];
                if (a >= 0 && a < 2 && b >= 0 && b < 3) {
                    auto r = t;
                    swap(r[x][y], r[a][b]);
                    if (!dist.count(r)) {
                        dist[r] = dist[t] + 1;
                        if (r == end) return dist[r];
                        q.push(r);
                    }
                }
            }
        }
        return -1;
    }
};

int main() {

    vector<vector<int>> board = {{4, 1, 2}, {5, 0, 3}};
    cout << Solution().slidingPuzzle(board) << endl;  // 5

    return 0;
}
