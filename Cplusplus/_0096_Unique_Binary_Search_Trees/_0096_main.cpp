// Created by WXX on 2021/1/25 16:16
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：0 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：5.8 MB, 在所有 C++ 提交中击败了96.93%的用户
 */
class Solution {
public:
    int numTrees(int n) {

        // f[i]: 表示一共i个不同的节点可以组成的数的个数
        vector<int> f(n + 1);
        f[0] = 1;
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= i; j++)
                f[i] += f[j - 1] * f[i - j];
        return f[n];
    }
};

int main() {

    cout << Solution().numTrees(3) << endl;  // 5

    return 0;
}