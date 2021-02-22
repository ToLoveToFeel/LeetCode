// Created by WXX on 2021/2/2 22:59
#include <iostream>

using namespace std;

/**
 * 执行用时：4 ms, 在所有 C++ 提交中击败了51.23%的用户
 * 内存消耗：5.7 MB, 在所有 C++ 提交中击败了94.99%的用户
 */
class Solution {
public:
    typedef long long LL;

    int integerReplacement(int n) {
        return f(n);
    }

    int f(LL n) {
        if (n == 1) return 0;
        if (n % 2 == 0) return f(n / 2) + 1;
        return min(f(n + 1), f(n - 1)) + 1;
    }
};

int main() {

    cout << Solution().integerReplacement(8) << endl;  // 3
    cout << Solution().integerReplacement(7) << endl;  // 4

    return 0;
}
