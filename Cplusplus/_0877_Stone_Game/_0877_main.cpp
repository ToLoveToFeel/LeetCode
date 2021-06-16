// Created by WXX on 2021/6/16 9:07
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：24 ms, 在所有 C++ 提交中击败了31.43%的用户
 * 内存消耗：16.1 MB, 在所有 C++ 提交中击败了13.22%的用户
 */
class Solution {
public:
    bool stoneGame(vector<int> &piles) {
        int n = piles.size();
        vector<vector<int>> f(n, vector<int>(n));
        for (int i = 0; i < n; i++) f[i][i] = piles[i];
        for (int len = 2; len <= n; len++)
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                f[i][j] = max(f[i + 1][j] + piles[i], f[i][j - 1] + piles[j]);
            }
        return f[0][n - 1] > min(f[1][n - 1], f[0][n - 2]);
    }
};

int main() {

    vector<int> piles = {5, 3, 4, 5};
    cout << Solution().stoneGame(piles) << endl;  // true

    return 0;
}
