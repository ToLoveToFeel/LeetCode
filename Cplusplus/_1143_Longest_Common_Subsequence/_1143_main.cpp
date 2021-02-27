// Created by WXX on 2021/2/27 16:59
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：32 ms, 在所有 C++ 提交中击败了32.10%的用户
 * 内存消耗：12.6 MB, 在所有 C++ 提交中击败了54.01%的用户
 */
class Solution {
public:
    int longestCommonSubsequence(string a, string b) {

        int n = a.size(), m = b.size();
        a = ' ' + a; b = " " + b;

        vector<vector<int>> f(n + 1, vector<int>(m + 1));
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++) {
                f[i][j] = max(f[i - 1][j], f[i][j - 1]);
                if (a[i] == b[j]) f[i][j] = max(f[i][j], f[i - 1][j - 1] + 1);
            }
        return f[n][m];
    }
};

int main() {

    cout << Solution().longestCommonSubsequence("abcde", "ace") << endl;  // 3

    return 0;
}
