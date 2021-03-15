// Created by WXX on 2021/3/15 21:16
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

/**
 * 执行用时：36 ms, 在所有 C++ 提交中击败了21.34%的用户
 * 内存消耗：26.3 MB, 在所有 C++ 提交中击败了9.78%的用户
 */
class Solution {
public:
    typedef pair<int, int> PII;
    int n, m;
    vector<vector<int>> g;
    vector<vector<bool>> st;
    int dx[4] = {-1, 0, 1, 0}, dy[4] = {0, 1, 0, -1};

    int maxAreaOfIsland(vector<vector<int>> &grid) {

        g = grid;
        n = g.size();
        if (n == 0) return 0;
        m = g[0].size();
        if (m == 0) return 0;
        st = vector<vector<bool>>(n, vector<bool>(m, false));

        int res = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (!st[i][j] && g[i][j] == 1)
                    res = max(res, bfs(i, j));
        return res;
    }

    int bfs(int sx, int sy) {

        queue<PII> q;
        q.push({sx, sy});
        st[sx][sy] = true;

        int area = 0;
        while (q.size()) {
            auto t = q.front(); q.pop();
            area++;
            for (int i = 0; i < 4; i++) {
                int a = t.first + dx[i], b = t.second + dy[i];
                if (a >= 0 && a < n && b >= 0 && b < m && g[a][b] == 1 && !st[a][b]) {
                    q.push({a, b});
                    st[a][b] = true;
                }
            }
        }
        return area;
    }
};

int main() {

    vector<vector<int>> grid = {
            {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
            {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
            {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
    };
    cout << Solution().maxAreaOfIsland(grid) << endl;  // 6

    return 0;
}
