// Created by WXX on 2021/7/19 19:24
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int maxValue(vector<vector<int>> &grid) {
        int n = grid.size(), m = grid[0].size();
        vector<vector<int>> f(n + 1, vector<int>(m + 1));
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                f[i][j] = max(f[i - 1][j], f[i][j - 1]) + grid[i - 1][j - 1];
        return f[n][m];
    }
};

int main() {

    vector<vector<int>> grid = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
    };
    cout << Solution().maxValue(grid) << endl;  // 12

    return 0;
}
