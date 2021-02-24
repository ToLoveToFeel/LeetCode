// Created by WXX on 2021/1/29 21:52
#include <iostream>
#include <vector>

using namespace std;

// 完全背包问题
/**
 * 执行用时：204 ms, 在所有 C++ 提交中击败了69.60%的用户
 * 内存消耗：8.7 MB, 在所有 C++ 提交中击败了83.16%的用户
 */
class Solution {
public:
    int numSquares(int n) {

        vector<int> f(n + 1, 1e9);  // f[i] 代表 i 最少可以由几个完全平方数表示
        f[0] = 0;
        for (int i = 1; i * i <= n; i++)  // 先循环物品 i*i
            for (int j = i * i; j <= n; j++)  // 再循环体积：体积从i*i开始
                f[j] = min(f[j], f[j - i * i] + 1);
        return f[n];
    }
};

int main() {

    cout << Solution().numSquares(12) << endl;  // 3
    cout << Solution().numSquares(13) << endl;  // 2

    return 0;
}