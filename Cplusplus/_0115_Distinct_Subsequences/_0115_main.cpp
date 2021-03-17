// Created by WXX on 2021/3/17 8:59
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：4 ms, 在所有 C++ 提交中击败了61.41%的用户
 * 内存消耗：7.3 MB, 在所有 C++ 提交中击败了32.38%的用户
 */
class Solution {
public:
    int numDistinct(string s, string t) {

        int n = s.size(), m = t.size();
        s = ' ' + s, t = ' ' + t;
        vector<vector<long long>> f(n + 1, vector<long long>(m + 1));
        for (int i = 0; i <= n; i++) f[i][0] = 1;
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++) {
                f[i][j] = f[i - 1][j];
                if (s[i] == t[j]) f[i][j] += f[i - 1][j - 1];
            }
        return f[n][m];
    }
};

int main() {

    cout << Solution().numDistinct("rabbbit", "rabbit") << endl;  // 3
    cout << Solution().numDistinct("babgbag", "bag") << endl;  // 5

    return 0;
}
