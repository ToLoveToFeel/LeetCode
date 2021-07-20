// Created by WXX on 2021/7/20 17:19
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：8 ms, 在所有 C++ 提交中击败了58.91%的用户
 * 内存消耗：12.4 MB, 在所有 C++ 提交中击败了72.04%的用户
 */
class Solution {
public:
    int maxProfit(vector<int> &prices) {
        int res = 0;
        for (int i = 0, minp = INT_MAX; i < prices.size(); i++) {
            res = max(res, prices[i] - minp);
            minp = min(minp, prices[i]);
        }
        return res;
    }
};

int main() {

    vector<int> prices = {7, 1, 5, 3, 6, 4};
    cout << Solution().maxProfit(prices) << endl;  // 5

    return 0;
}
