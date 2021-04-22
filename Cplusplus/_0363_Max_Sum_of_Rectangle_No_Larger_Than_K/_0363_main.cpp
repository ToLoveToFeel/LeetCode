// Created by WXX on 2021/4/22 8:53
#include <iostream>
#include <vector>
#include <set>

using namespace std;

/**
 * 执行用时：648 ms, 在所有 C++ 提交中击败了30.25%的用户
 * 内存消耗：128.3 MB, 在所有 C++ 提交中击败了5.11%的用户
 */
class Solution {
public:
    vector<vector<int>> sum;  //  二维前缀和

    int get(int x1, int y1, int x2, int y2) {
        return sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1];
    }

    int maxSumSubmatrix(vector<vector<int>> &w, int K) {

        int n = w.size(), m = w[0].size();
        sum = vector<vector<int>>(n + 1, vector<int>(m + 1));
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + w[i - 1][j - 1];

        int res = INT_MIN;
        for (int i = 1; i <= m; i++)
            for (int j = i; j <= m; j++) {
                set<int> S;
                S.insert(0);
                for (int k = 1; k <= n; k++) {
                    int si = get(1, i, k, j);
                    auto it = S.lower_bound(si - K);
                    if (it != S.end()) res = max(res, si - *it);
                    S.insert(si);
                }
            }
        return res;
    }
};

int main() {

    vector<vector<int>> w = {
            {1, 0, 1},
            {0, -2, 3},
    };
    cout << Solution().maxSumSubmatrix(w, 2) << endl;  // 2

    return 0;
}
