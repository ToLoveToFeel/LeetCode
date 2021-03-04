// Created by WXX on 2021/3/4 9:22
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// LIS模型
/**
 * 执行用时：1464 ms, 在所有 C++ 提交中击败了19.36%的用户
 * 内存消耗：13.4 MB, 在所有 C++ 提交中击败了76.45%的用户
 */
class Solution {
public:
    int maxEnvelopes(vector<vector<int>> &w) {

        int n = w.size();
        sort(w.begin(), w.end());
        vector<int> f(n);

        int res = 0;
        for (int i = 0; i < n; i++) {
            f[i] = 1;
            for (int j = 0; j < i; j++)
                if (w[j][0] < w[i][0] && w[j][1] < w[i][1])
                    f[i] = max(f[i], f[j] + 1);
            res = max(res, f[i]);
        }
        return res;
    }
};

int main() {

    vector<vector<int>> w = {{5, 4},
                             {6, 4},
                             {6, 7},
                             {2, 3}};
    cout << Solution().maxEnvelopes(w) << endl;

    return 0;
}
