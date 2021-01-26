// Created by WXX on 2021/1/26 17:05
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：16 ms, 在所有 C++ 提交中击败了98.27%的用户
 * 内存消耗：9.4 MB, 在所有 C++ 提交中击败了93.39%的用户
 */
class Solution {
public:

    vector<vector<char>> g;
    int dx[4] = {-1, 0, 1, 0}, dy[4] = {0, 1, 0, -1};

    int numIslands(vector<vector<char>> &grid) {

        g = grid;
        int cnt = 0;
        for (int i = 0; i < g.size(); i++) {
            for (int j = 0; j < g[0].size(); j++)
                if (g[i][j] == '1') {
                    dfs(i, j);
                    cnt++;
                }
        }
        return cnt;
    }

    void dfs(int x, int y) {
        g[x][y] = '0';
        for (int i = 0; i < 4; i++) {
            int a = x + dx[i], b = y + dy[i];
            if (a >= 0 && a < g.size() && b >= 0 && b < g[0].size() && g[a][b] == '1')
                dfs(a, b);
        }
    }
};

int main() {

    vector<vector<char>> grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
    };
    cout << Solution().numIslands(grid) << endl;  // 3

    return 0;
}
