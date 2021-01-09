#include <iostream>
#include <vector>

using namespace std;

/**
 * f[i][0]: 手上不持有股票，并且不在冷冻期中的累计最大收益
 * f[i][1]: 手上持有股票的最大收益
 * f[i][2]: 手上不持有股票，并且处于冷冻期中的累计最大收益
 * <p>
 * 执行用时：8 ms, 在所有 C++ 提交中击败了64.23%的用户
 * 内存消耗：11.9 MB, 在所有 C++ 提交中击败了17.15%的用户
 */
class Solution {
public:
    int maxProfit(vector<int> &prices) {

        if (prices.empty()) return 0;
        int n = prices.size();
        vector<vector<int>> f(n, vector<int>(3));
        f[0][1] = -prices[0], f[0][0] = 0;
        for (int i = 1; i < n; i++) {
            f[i][0] = max(f[i - 1][0], f[i - 1][2]);
            f[i][1] = max(f[i - 1][1], f[i - 1][0] - prices[i]);
            f[i][2] = f[i - 1][1] + prices[i];
        }
        return max(f[n - 1][0], f[n - 1][2]);
    }
};

int main() {

    vector<int> prices = {1, 2, 4};
    cout << Solution().maxProfit(prices) << endl;

    return 0;
}