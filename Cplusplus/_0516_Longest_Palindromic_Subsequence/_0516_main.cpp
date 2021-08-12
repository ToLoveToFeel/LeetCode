// Created by ToLoveToFeel on 2021/8/12 09:35
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int longestPalindromeSubseq(string s) {
        int n = s.size();
        vector<vector<int>> f(n, vector<int>(n));
        for (int len = 1; len <= n; len++)
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (len == 1) f[i][j] = 1;
                else {
                    if (s[i] == s[j]) f[i][j] = f[i + 1][j - 1] + 2;
                    f[i][j] = max(f[i][j], max(f[i][j - 1], f[i + 1][j]));
                }
            }
        return f[0][n - 1];
    }
};

int main() {

    cout << Solution().longestPalindromeSubseq("bbbab") << endl;  // 4
    cout << Solution().longestPalindromeSubseq("cbbd") << endl;  // 2

    return 0;
}
