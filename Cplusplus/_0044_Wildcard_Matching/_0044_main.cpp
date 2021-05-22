// Created by WXX on 2021/5/22 11:20
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：96 ms, 在所有 C++ 提交中击败了47.75%的用户
 * 内存消耗：11.1 MB, 在所有 C++ 提交中击败了51.67%的用户
 */
class Solution {
public:
    bool isMatch(string s, string p) {
        int n = s.size(), m = p.size();
        s = " " + s, p = ' ' + p;
        vector<vector<bool>> f(n + 1, vector<bool>(m + 1));
        f[0][0] = true;
        for (int i = 0; i <= n; i++)  // f[0][j]是有意义的，例如p="***"，因此i从0开始
            for (int j = 1; j <= m; j++)  // f[i][0] (i>0)是没有意义的，因此j从1开始
                if (p[j] != '*') {
                    f[i][j] = (s[i] == p[j] || p[j] == '?') && i && f[i - 1][j - 1];
                } else {
                    f[i][j] = f[i][j - 1] || (i && f[i - 1][j]);
                }
        return f[n][m];
    }
};

int main() {

    cout << Solution().isMatch("aa", "a") << endl;  // false

    return 0;
}
