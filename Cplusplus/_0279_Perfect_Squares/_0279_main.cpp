// Created by WXX on 2021/1/29 21:52
#include <iostream>
#include <vector>

using namespace std;

// 完全背包问题
class Solution {
public:
    int numSquares(int n) {

        vector<int> f(n + 1, 1e9);  // f[i] 代表 i 最少可以由几个完全平方数表示
        f[0] = 0;
        for (int i = 1; i <= n; i++)
            for (int j = 1; j * j <= i; j++)
                f[i] = min(f[i], f[i - j * j] + 1);
        return f[n];
    }
};

int main() {

    cout << Solution().numSquares(12) << endl;  // 3
    cout << Solution().numSquares(13) << endl;  // 2

    return 0;
}