// Created by WXX on 2021/2/25 21:41
#include <iostream>

using namespace std;

// lowbit
/**
 * 执行用时：0 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：5.5 MB, 在所有 C++ 提交中击败了99.93%的用户
 */
class Solution {
public:
    bool isPowerOfTwo(int n) {
        return n > 0 && (n & -n) == n;
    }
};

int main() {

    cout << Solution().isPowerOfTwo(1) << endl;  // true
    cout << Solution().isPowerOfTwo(16) << endl;  // true
    cout << Solution().isPowerOfTwo(218) << endl;  // false

    return 0;
}
