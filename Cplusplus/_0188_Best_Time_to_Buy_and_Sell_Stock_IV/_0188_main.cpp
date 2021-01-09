#include <cstring>
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：8 ms, 在所有 C++ 提交中击败了86.85%的用户
 * 内存消耗：10.7 MB, 在所有 C++ 提交中击败了99.85%的用户
 */
int f[101], g[101];  // f存储最后持有现金的结果，g存储最后持有股票的结果，0<=k<=100

class Solution {
public:
    int maxProfit(int k, vector<int> &prices) {

        int n = prices.size();
        if (k >= n / 2) {  // Leetcode 0112
            int res = 0;
            for (int i = 0; i + 1 < n; i++)
                res += max(0, prices[i + 1] - prices[i]);
            return res;
        }

        memset(f, -0x3f, sizeof f);
        memset(g, -0x3f, sizeof g);
        f[0] = 0;
        int res = 0;
        for (int i = 1; i <= n; i++)
            for (int j = k; j >= 0; j--) {  // 因为需要用到之前的信息
                g[j] = max(g[j], f[j] - prices[i - 1]);
                if (j) f[j] = max(f[j], g[j - 1] + prices[i - 1]);
            }
        for (int i = 1; i <= k; i++) res = max(res, f[i]);
        return res;
    }
};

int main() {

    vector<int> prices = {3, 3, 5, 0, 0, 3, 1, 4};
    cout << Solution().maxProfit(1, prices) << endl;

    return 0;
}