// Created by WXX on 2021/1/25 16:29
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    bool isInterleave(string s1, string s2, string s3) {

        int n = s1.size(), m = s2.size();
        if (s3.size() != n + m) return false;

        vector<vector<bool>> f(n + 1, vector<bool>(m + 1));
        s1 = ' ' + s1, s2 = ' ' + s2, s3 = ' ' + s3;
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= m; j++) {
                if (!i && !j) f[i][j] = true;
                else {
                    if (i && s1[i] == s3[i + j]) f[i][j] = f[i - 1][j];
                    if (j && s2[j] == s3[i + j]) f[i][j] = f[i][j] || f[i][j - 1];
                }
            }
        return f[n][m];
    }
};

int main() {

    string s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
    cout << Solution().isInterleave(s1, s2, s3) << endl;  // true

    return 0;
}
