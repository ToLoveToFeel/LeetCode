// Created by WXX on 2021/7/1 14:24
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int n, m;
    vector<vector<bool>> st;
    pair<int, int> S, T;  // 起点，终点
    int ans;
    int dx[4] = {-1, 0, 1, 0}, dy[4] = {0, 1, 0, -1};

    int uniquePathsIII(vector<vector<int>> &grid) {

        n = grid.size();
        m = grid[0].size();
        st = vector<vector<bool>>(n, vector<bool>(m, false));
        ans = 0;

        int cnt = n * m;  // 初始表示多少个可以走的格子数目
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] == 1) S = make_pair(i, j);
                else if (grid[i][j] == 2) T = make_pair(i, j);
                else if (grid[i][j] == -1) cnt--;
        dfs(grid, S.first, S.second, cnt - 1);
        return ans;
    }

    void dfs(vector<vector<int>> &grid, int x, int y, int cnt) {

        if (!cnt && x == T.first && y == T.second) {
            ans++;
            return;
        }

        st[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int a = x + dx[i], b = y + dy[i];
            if (a >= 0 && a < n && b >= 0 && b < m && !st[a][b] && grid[a][b] != -1)
                dfs(grid, a, b, cnt - 1);
        }
        st[x][y] = false;
    }
};

int main() {

    vector<vector<int>> grid = {
            {1, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 2}
    };
    cout << Solution().uniquePathsIII(grid) << endl;  // 4

    return 0;
}
