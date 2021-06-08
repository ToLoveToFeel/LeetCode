// Created by WXX on 2021/6/8 9:34
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：0 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：8.1 MB, 在所有 C++ 提交中击败了49.56%的用户
 */
class Solution {
public:
    int lastStoneWeightII(vector<int> &stones) {
        int sum = 0;
        for (auto x : stones) sum += x;
        int m = sum / 2;
        vector<int> f(m + 1);
        for (auto x : stones)
            for (int j = m; j >= x; j--)
                f[j] = max(f[j], f[j - x] + x);
        return (sum - f[m]) - f[m];
    }
};

int main() {

    vector<int> stones = {2, 7, 4, 1, 8, 1};
    cout << Solution().lastStoneWeightII(stones) << endl;  // 1

    return 0;
}
