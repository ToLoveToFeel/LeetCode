// Created by ToLoveToFeel on 2021/8/15 09:59
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int findPaths(int m, int n, int maxMove, int x, int y) {
        if (!maxMove) return 0;
        const int MOD = 1e9 + 7;
        vector<vector<vector<int>>> f(m, vector<vector<int>>(n, vector<int>(maxMove + 1)));
        for (int i = 0; i < n; i++) {
            f[0][i][1] += 1;
            f[m - 1][i][1] += 1;
        }
        for (int i = 0; i < m; i++) {
            f[i][0][1] += 1;
            f[i][n - 1][1] += 1;
        }

        int dx[4] = {-1, 0, 1, 0}, dy[4] = {0, 1, 0, -1};
        for (int k = 1; k <= maxMove; k++)
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    for (int u = 0; u < 4; u++) {
                        int a = i + dx[u], b = j + dy[u];
                        if  (a >= 0 && a < m && b >= 0 && b < n)
                            (f[i][j][k] += f[a][b][k - 1]) %= MOD;
                    }

        int res = 0;
        for (int k = 0; k <= maxMove; k++)
            res = (res + f[x][y][k]) % MOD;
        return res;
    }
};

int main() {

    cout << Solution().findPaths(2, 2, 2, 0, 0) << endl;  // 6

    return 0;
}
