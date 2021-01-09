#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：4 ms, 在所有 C++ 提交中击败了90.80%的用户
 * 内存消耗：7.6 MB, 在所有 C++ 提交中击败了56.19%的用户
 */
class Solution {
public:
    int maxProfit(vector<int> &prices) {
        int res = 0;
        for (int i = 0; i + 1 < prices.size(); i++)
            res += max(0, prices[i + 1] - prices[i]);
        return res;
    }
};

int main() {

    vector<int> prices = {7, 1, 5, 3, 6, 4};
    cout << Solution().maxProfit(prices) << endl;

    return 0;
}