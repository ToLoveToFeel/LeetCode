// Created by WXX on 2021/2/25 21:27
#include <iostream>
#include <cmath>

using namespace std;

/**
 * 执行用时：0 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：5.8 MB, 在所有 C++ 提交中击败了82.90%的用户
 */
class Solution {
public:
    bool isPowerOfFour(int n) {

        if (n <= 0) return false;
        int r = sqrt(n);
        if (r * r != n) return false;
        return (1 << 30) % n == 0;
    }
};

int main() {

    cout << Solution().isPowerOfFour(16) << endl;  // true
    cout << Solution().isPowerOfFour(5) << endl;  // false
    cout << Solution().isPowerOfFour(1) << endl;  // true

    return 0;
}
