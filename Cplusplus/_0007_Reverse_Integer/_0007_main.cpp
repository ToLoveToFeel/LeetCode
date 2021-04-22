#include <iostream>

using namespace std;

/**
 * C++中 -1234 % 10 = -4， -1234 / 10 = -123
 * 执行用时：0 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：6.2 MB, 在所有 C++ 提交中击败了47.91%的用户
 */
class Solution {
public:
    int reverse(int x) {
        int r = 0;
        while (x) {
            if (r > 0 && r > (INT_MAX - x % 10) / 10) return 0;
            if (r < 0 && r < (INT_MIN - x % 10) / 10) return 0;
            r = r * 10 + x % 10;
            x /= 10;
        }
        return r;
    }
};

int main() {

    cout << Solution().reverse(1234) << endl;  // 4321
    cout << Solution().reverse(-1234) << endl;  // -4321
    cout << Solution().reverse(INT_MAX) << endl;  // 0
    cout << Solution().reverse(INT_MIN) << endl;  // 0

    return 0;
}
