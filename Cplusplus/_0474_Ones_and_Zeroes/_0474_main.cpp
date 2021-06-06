// Created by WXX on 2021/6/6 10:29
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：248 ms, 在所有 C++ 提交中击败了71.63%的用户
 * 内存消耗：9.4 MB, 在所有 C++ 提交中击败了65.28%的用户
 */
class Solution {
public:
    int findMaxForm(vector<string> &strs, int m, int n) {
        vector<vector<int>> f(m + 1, vector<int>(n + 1));
        for (auto &str : strs) {
            int a = 0, b = 0;
            for (auto c : str)
                if (c == '0') a++;
                else b++;
            for (int i = m; i >= a; i--)
                for (int j = n; j >= b; j--)
                    f[i][j] = max(f[i][j], f[i - a][j - b] + 1);
        }
        return f[m][n];
    }
};

int main() {

    vector<string> strs = {"10", "0001", "111001", "1", "0"};
    cout << Solution().findMaxForm(strs, 5, 3) << endl;  // 4

    return 0;
}
