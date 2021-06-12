// Created by WXX on 2021/6/12 10:44
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：28 ms, 在所有 C++ 提交中击败了88.08%的用户
 * 内存消耗：13.6 MB, 在所有 C++ 提交中击败了85.43%的用户
 */
class Solution {
public:
    string largestNumber(vector<int> &cost, int target) {
        int n = cost.size();
        vector<vector<int>> f(n + 1, vector<int>(target + 1, -2e9));
        f[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            int v = cost[i - 1];
            for (int j = 0; j <= target; j++) {
                f[i][j] = f[i - 1][j];
                if (j >= v) f[i][j] = max(f[i][j], f[i][j - v] + 1);
            }
        }
        if (f[n][target] < -1e9) return "0";
        string res;
        int j = target;
        for (int i = n; i >= 1; i--) {
            int v = cost[i - 1];
            while (j >= v && f[i][j] == f[i][j - v] + 1) {
                res += to_string(i);
                j -= v;
            }
        }
        return res;
    }
};

int main() {

    vector<int> cost = {4, 3, 2, 5, 6, 7, 2, 5, 5};
    cout << Solution().largestNumber(cost, 9) << endl;  // 7772

    return 0;
}
