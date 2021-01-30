// Created by WXX on 2021/1/30 20:37
#include <iostream>

using namespace std;

/**
 * 执行用时：0 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：5.8 MB, 在所有 C++ 提交中击败了89.69%的用户
 */
class Solution {
public:
    bool canWinNim(int n) {

        return n % 4;
    }
};

int main() {

    cout << Solution().canWinNim(4) << endl;  // false
    cout << Solution().canWinNim(1) << endl;  // true

    return 0;
}
