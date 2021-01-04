#include <iostream>

using namespace std;

/**
 * 执行用时：24 ms, 在所有 C++ 提交中击败了27.51%的用户
 * 内存消耗：6.2 MB, 在所有 C++ 提交中击败了31.32%的用户
 */
class Solution {
public:
    bool isPalindrome(int x) {

        if (x < 0) return false;

        int y = x;
        long long res = 0;
        while (x) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res == y;
    }
};

int main() {

    cout << Solution().isPalindrome(121) << endl;  // true
    cout << Solution().isPalindrome(-121) << endl;  // false

    return 0;
}
