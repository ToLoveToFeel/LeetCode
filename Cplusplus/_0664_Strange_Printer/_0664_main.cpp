// Created by WXX on 2021/5/24 10:51
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：48 ms, 在所有 C++ 提交中击败了35.42%的用户
 * 内存消耗：9.3 MB, 在所有 C++ 提交中击败了55.17%的用户
 */
class Solution {
public:
    int strangePrinter(string s) {
        int n = s.size();
        vector<vector<int>> f(n + 1, vector<int>(n));
        for (int len = 1; len <= n; len++)
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                f[i][j] = f[i + 1][j] + 1;
                for (int k = i + 1; k <= j; k++)
                    if (s[i] == s[k])
                        f[i][j] = min(f[i][j], f[i][k - 1] + f[k + 1][j]);
            }
        return f[0][n - 1];
    }
};

int main() {

    cout << Solution().strangePrinter("aaabbb") << endl;  // 2

    return 0;
}
