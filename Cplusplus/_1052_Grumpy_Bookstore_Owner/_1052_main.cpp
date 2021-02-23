// Created by WXX on 2021/2/23 9:30
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：44 ms, 在所有 C++ 提交中击败了66.29%的用户
 * 内存消耗：29.4 MB, 在所有 C++ 提交中击败了63.39%的用户
 */
class Solution {
public:
    int maxSatisfied(vector<int> &c, vector<int> &g, int X) {

        int n = c.size(), res = 0;
        for (int i = 0; i < n; i++)
            if (i < X) res += c[i];
            else res += (1 - g[i]) * c[i];

        for (int i = X, j = 0, t = res; i < n; i++, j++) {
            t = t + g[i] * c[i] - g[j] * c[j];  // 滑动窗口[j + 1...i]
            res = max(res, t);
        }
        return res;
    }
};

int main() {

    vector<int> c = {1, 0, 1, 2, 1, 1, 7, 5}, g = {0, 1, 0, 1, 0, 1, 0, 1};
    int X = 3;
    cout << Solution().maxSatisfied(c, g, X) << endl;

    return 0;
}
