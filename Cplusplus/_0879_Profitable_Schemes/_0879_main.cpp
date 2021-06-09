// Created by WXX on 2021/6/9 9:42
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：116 ms, 在所有 C++ 提交中击败了72.67%的用户
 * 内存消耗：8.8 MB, 在所有 C++ 提交中击败了68.53%的用户
 */
class Solution {
public:
    static const int mod = 1e9 + 7;

    int profitableSchemes(int n, int m, vector<int> &group, vector<int> &profit) {
        vector<vector<int>> f(n + 1, vector<int>(m + 1));
        for (int i = 0; i <= n; i++) f[i][0] = 1;
        for (int i = 0; i < group.size(); i++) {
            int g = group[i], p = profit[i];
            for (int j = n; j >= g; j--)
                for (int k = m; k >= 0; k--)
                    f[j][k] = (f[j][k] + f[j - g][max(0, k - p)]) % mod;
        }
        return f[n][m];
    }
};

int main() {

//    vector<int> group = {2, 2};
//    vector<int> profit = {2, 3};
//    cout << Solution().profitableSchemes(5, 3, group, profit) << endl;  // 2

    vector<int> group = {2, 3, 5};
    vector<int> profit = {6, 7, 8};
    cout << Solution().profitableSchemes(10, 5, group, profit) << endl;  // 7

    return 0;
}
