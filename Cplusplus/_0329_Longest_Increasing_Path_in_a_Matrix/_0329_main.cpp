// Created by WXX on 2021/2/23 0:06
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：36 ms, 在所有 C++ 提交中击败了99.67%的用户
 * 内存消耗：16.6 MB, 在所有 C++ 提交中击败了24.78%的用户
 */
class Solution {
public:
    int n, m;
    vector<vector<int>> f, w;
    int dx[4] = {-1, 0, 1, 0}, dy[4] = {0, 1, 0, -1};

    int dp(int x, int y) {
        auto &v = f[x][y];
        if (v != -1) return v;
        v = 1;
        for (int i = 0; i < 4; i++) {
            int a = x + dx[i], b = y + dy[i];
            if (a >= 0 && a < n && b >= 0 && b < m && w[x][y] < w[a][b])
                v = max(v, dp(a, b) + 1);
        }
        return v;
    }

    int longestIncreasingPath(vector<vector<int>> &matrix) {

        if (matrix.empty() || matrix[0].empty()) return 0;
        w = matrix;
        n = w.size(), m = w[0].size();
        f = vector<vector<int>>(n, vector<int>(m, -1));

        int res = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                res = max(res, dp(i, j));
        return res;
    }
};

int main() {

    vector<vector<int>> matrx = {{9, 9, 4},
                                 {6, 6, 8},
                                 {2, 1, 1}};
    cout << Solution().longestIncreasingPath(matrx) << endl;  // 4

    return 0;
}
