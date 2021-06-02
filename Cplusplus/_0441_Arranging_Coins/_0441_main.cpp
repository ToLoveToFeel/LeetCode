// Created by WXX on 2021/6/2 20:03
#include <iostream>
#include <cmath>

using namespace std;

/**
 * 执行用时：8 ms, 在所有 C++ 提交中击败了51.54%的用户
 * 内存消耗：5.8 MB, 在所有 C++ 提交中击败了76.32%的用户
 */
class Solution {
public:
    int arrangeCoins(int n) {
        return (-1 + sqrt(1 + 8.0 * n)) / 2;
    }
};

int main() {

    cout << Solution().arrangeCoins(5) << endl;  // 2
    cout << Solution().arrangeCoins(8) << endl;  // 3

    return 0;
}
