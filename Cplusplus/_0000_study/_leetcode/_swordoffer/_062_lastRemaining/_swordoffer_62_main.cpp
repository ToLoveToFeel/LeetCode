// Created by WXX on 2021/5/30 19:25
#include <iostream>

using namespace std;

/**
 * 执行用时：8 ms, 在所有 C++ 提交中击败了72.74%的用户
 * 内存消耗：8.7 MB, 在所有 C++ 提交中击败了21.80%的用户
 */
class Solution {
public:
    int lastRemaining(int n, int m) {
        if (n == 1) return 0;
        return (lastRemaining(n - 1, m) + m) % n;
    }
};

int main() {

    cout << Solution().lastRemaining(5, 3) << endl;  // 3

    return 0;
}
