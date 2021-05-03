// Created by WXX on 2021/5/3 18:50
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int calculateMinimumHP(vector<vector<int>> &w) {

        int n = w.size(), m = w[0].size();
        vector<vector<int>> f(n, vector<int>(m, 1e8));
        for (int i = n - 1; ~i; i--)
            for (int j = m - 1; ~j; j--) {
                if (i == n - 1 && j == m - 1) f[i][j] = max(1, 1 - w[i][j]);
                else {
                    if (i + 1 < n) f[i][j] = f[i + 1][j] - w[i][j];
                    if (j + 1 < m) f[i][j] = min(f[i][j], f[i][j + 1] - w[i][j]);
                    f[i][j] = max(1, f[i][j]);
                }
            }
        return f[0][0];
    }
};

int main() {

    vector<vector<int>> w = {
            {-2, -3, 3},
            {-5, -10, 1},
            {10, 30, -5},
    };
    cout << Solution().calculateMinimumHP(w) << endl;  // 7

    return 0;
}
