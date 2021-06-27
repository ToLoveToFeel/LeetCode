// Created by WXX on 2021/6/27 14:57
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

#define x first
#define y second

typedef pair<int, int> PII;

/**
 * 执行用时：20 ms, 在所有 C++ 提交中击败了60.53%的用户
 * 内存消耗：13.6 MB, 在所有 C++ 提交中击败了30.70%的用户
 */
class Solution {
public:
    vector<vector<int>> id;  // 坐标->编号
    vector<PII> cor;  // 标号->坐标

    int snakesAndLadders(vector<vector<int>> &board) {
        int n = board.size();
        id = vector<vector<int>>(n, vector<int>(n));
        cor = vector<PII>(n * n + 1);
        for (int i = n - 1, k = 1, s = 0; i >= 0; i--, s++) {
            if (s % 2 == 0) {  // 从左到右编号
                for (int j = 0; j < n; j++, k++) {
                    id[i][j] = k;
                    cor[k] = {i, j};
                }
            } else {
                for (int j = n - 1; j >= 0; j--, k++) {
                    id[i][j] = k;
                    cor[k] = {i, j};
                }
            }
        }

        queue<PII> q;
        vector<vector<int>> dist(n, vector<int>(n, 1e9));
        dist[n - 1][0] = 0;
        q.push({n - 1, 0});
        while (q.size()) {
            auto t = q.front();
            q.pop();

            int k = id[t.x][t.y];
            if (k == n * n) return dist[t.x][t.y];
            for (int i = k + 1; i <= k + 6 && i <= n * n; i++) {
                int x = cor[i].x, y = cor[i].y;
                if (board[x][y] != -1) {  // 每个会和只能传送一次
                    int r = board[x][y];
                    x = cor[r].x, y = cor[r].y;
                }
                if (dist[x][y] > dist[t.x][t.y] + 1) {
                    dist[x][y] = dist[t.x][t.y] + 1;
                    q.push({x, y});
                }
            }
        }
        return -1;
    }
};

int main() {

    vector<vector<int>> board = {
            {-1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1},
            {-1, 35, -1, -1, 13, -1},
            {-1, -1, -1, -1, -1, -1},
            {-1, 15, -1, -1, -1, -1}
    };
    cout << Solution().snakesAndLadders(board) << endl;  // 4

    return 0;
}
