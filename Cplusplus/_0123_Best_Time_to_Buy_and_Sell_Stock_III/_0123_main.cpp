#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：304 ms, 在所有 C++ 提交中击败了85.27%的用户
 * 内存消耗：76.9 MB, 在所有 C++ 提交中击败了46.00%的用户
 */
class Solution {
public:
    int maxProfit(vector<int> &prices) {
        int n = prices.size();
        vector<int> f(n + 2);
        for (int i = 1, minp = INT_MAX; i <= n; i++) {
            f[i] = max(f[i - 1], prices[i - 1] - minp);
            minp = min(minp, prices[i - 1]);
        }

        int res = 0;
        for (int i = n, maxp = 0; i; i--) {
            res = max(res, maxp - prices[i - 1] + f[i - 1]);
            maxp = max(maxp, prices[i - 1]);
        }
        return res;
    }
};

int main() {

    vector<int> prices = {3, 3, 5, 0, 0, 3, 1, 4};
    prices = {1, 2, 3, 4, 5};
    cout << Solution().maxProfit(prices) << endl;

    return 0;
}