// Created by WXX on 2021/7/18 16:18
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    bool isMatch(string s, string p) {
        int n = s.size(), m = p.size();
        s  = ' ' + s, p = ' ' + p;
        vector<vector<bool>> f(n + 1, vector<bool>(m + 1));
        f[0][0] = true;
        for (int i = 0; i <= n; i++)
            for (int j = 1; j <= m; j++) {
                if (j + 1 <= m && p[j + 1] == '*') continue;
                if (i && p[j] != '*') f[i][j] = f[i - 1][j - 1] && (s[i] == p[j] || p[j] == '.');
                else if (p[j] == '*')
                    f[i][j] = f[i][j - 2] || (i && f[i - 1][j] && (s[i] == p[j - 1] || p[j - 1] == '.'));
            }
        return f[n][m];
    }
};

int main() {

    cout << Solution().isMatch("aa", "a") << endl;  // false
    cout << Solution().isMatch("aa", "a*") << endl;  // true
    cout << Solution().isMatch("ab", ".*") << endl;  // true
    cout << Solution().isMatch("aab", "c*a*b") << endl;  // true

    return 0;
}
