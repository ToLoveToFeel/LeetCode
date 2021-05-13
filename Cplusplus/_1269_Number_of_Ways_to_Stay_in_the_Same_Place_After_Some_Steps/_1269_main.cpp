// Created by WXX on 2021/5/13 10:20
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    const int mod = 1e9 + 7;

    int numWays(int steps, int arrLen) {

        int n = steps, m = min(arrLen - 1, steps);
        vector<vector<int>> f(n + 1, vector<int>(m + 1));
        f[0][0] = 1;
        for (int i = 1; i <= n; i++)
            for (int j = 0; j <= m; j++) {
                f[i][j] = f[i - 1][j];
                if (j - 1 >= 0) f[i][j] = (f[i][j] + f[i - 1][j - 1]) % mod;
                if (j + 1 <= m) f[i][j] = (f[i][j] + f[i - 1][j + 1]) % mod;
            }
        return f[n][0];
    }
};

int main() {

    cout << Solution().numWays(3, 2) << endl;  // 4
    cout << Solution().numWays(2, 4) << endl;  // 2
    cout << Solution().numWays(4, 2) << endl;  // 8

    return 0;
}
