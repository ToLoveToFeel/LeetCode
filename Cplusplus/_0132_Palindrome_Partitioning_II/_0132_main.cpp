// Created by WXX on 2021/1/25 22:22
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：28 ms, 在所有 C++ 提交中击败了85.90%的用户
 * 内存消耗：7.1 MB, 在所有 C++ 提交中击败了82.55%的用户
 */
class Solution {
public:
    int minCut(string s) {

        int n = s.size();
        s = ' ' + s;
        vector<vector<bool>> g(n + 1, vector<bool>(n + 1));
        vector<int> f(n + 1, 1e8);  // f[i]：代表s[1...i]最少可以被分为多少个回文串
        // 预处理：g[i][j]代表s[i...j]是否为回文串
        for (int j = 1; j <= n; j++)
            for (int i = 1; i <= j; i++)
                if (i == j) g[i][j] = true;
                else if (s[i] == s[j]) {
                    if (i + 1 > j - 1 || g[i + 1][j - 1]) g[i][j] = true;
                }

        f[0] = 0;
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= i; j++)
                if (g[j][i])
                    f[i] = min(f[i], f[j - 1] + 1);
        return f[n] - 1;
    }
};

int main() {

    string s = "aab";  // 1
    cout << Solution().minCut(s) << endl;

    return 0;
}
