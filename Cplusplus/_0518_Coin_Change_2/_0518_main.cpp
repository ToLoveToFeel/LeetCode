// Created by WXX on 2021/6/10 9:38
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：8 ms, 在所有 C++ 提交中击败了96.62%的用户
 * 内存消耗：7.1 MB, 在所有 C++ 提交中击败了26.14%的用户
 */
class Solution {
public:
    int change(int m, vector<int> &coins) {
        vector<int> f(m + 1);
        f[0] = 1;
        for (int v : coins)
            for (int j = v; j <= m; j++)
                f[j] += f[j - v];
        return f[m];
    }
};

int main() {

    vector<int> coins = {1, 2, 5};
    cout << Solution().change(5, coins) << endl;  // 4

    return 0;
}
