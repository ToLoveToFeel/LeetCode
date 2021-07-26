// Created by WXX on 2021/7/26 9:28
#include <iostream>
#include <vector>

using namespace std;

// TLE
class Solution {
public:
    int minOperations(vector<int> &a, vector<int> &b) {  // LCS
        int n = a.size(), m = b.size();
        vector<vector<int>> f(n + 1, vector<int>(m + 1));
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++) {
                f[i][j] = max(f[i][j - 1], f[i - 1][j]);
                if (a[i - 1] == b[j - 1]) f[i][j] = max(f[i][j], f[i - 1][j - 1] + 1);
            }
        return a.size() - f[n][m];
    }
};

int main() {

    vector<int> a = {5, 1, 3}, b = {9, 4, 2, 3, 4};
    cout << Solution().minOperations(a, b) << endl;  // 2

    return 0;
}
