// Created by WXX on 2021/2/22 21:31
#include <iostream>
#include <vector>

using namespace std;

// 完全背包问题：m为容量；物品体积为coins[i]，价值为1
/**
 * 执行用时：64 ms, 在所有 C++ 提交中击败了89.56%的用户
 * 内存消耗：13.7 MB, 在所有 C++ 提交中击败了66.94%的用户
 */
class Solution {
public:
    int coinChange(vector<int> &coins, int m) {

        vector<int> f(m + 1, 1e8);
        f[0] = 0;
        for (auto v : coins)
            for (int j = v; j <= m; j++)
                f[j] = min(f[j], f[j - v] + 1);
        if (f[m] == 1e8) return -1;
        return f[m];
    }
};

int main() {

    vector<int> coins = {1, 2, 5};
    cout << Solution().coinChange(coins, 11) << endl;  // 3

    return 0;
}
