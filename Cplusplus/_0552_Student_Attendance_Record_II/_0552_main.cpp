// Created by ToLoveToFeel on 2021/8/17 10:47
#include <iostream>

using namespace std;

/**
 * 执行用时：80 ms, 在所有 C++ 提交中击败了47.32%的用户
 * 内存消耗：8.1 MB, 在所有 C++ 提交中击败了47.32%的用户
 */
const int mod = 1e9 + 7, N = 100010;

int f[N][2][3];

class Solution {
public:
    int checkRecord(int n) {

        memset(f, 0, sizeof f);
        f[0][0][0] = 1;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < 2; j++)
                for (int k = 0; k < 3; k++) {
                    if (!j) f[i + 1][j + 1][0] = (f[i + 1][j + 1][0] + f[i][j][k]) % mod;  // A
                    if (k + 1 < 3) f[i + 1][j][k + 1] = (f[i + 1][j][k + 1] + f[i][j][k]) % mod;  // L
                    f[i + 1][j][0] = (f[i + 1][j][0] + f[i][j][k]) % mod;  // P
                }

        int res = 0;
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 3; j++)
                res = (res + f[n][i][j]) % mod;
        return res;
    }
};

int main() {

    cout << Solution().checkRecord(2) << endl;  // 8
    cout << Solution().checkRecord(10101) << endl;  // 183236316

    return 0;
}
