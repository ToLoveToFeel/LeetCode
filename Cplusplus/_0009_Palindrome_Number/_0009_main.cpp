#include <iostream>

using namespace std;

/**
 * 执行用时：32 ms, 在所有 C++ 提交中击败了14.04%的用户
 * 内存消耗：6.2 MB, 在所有 C++ 提交中击败了26.97%的用户
 */
class Solution {
public:
    bool isPalindrome(int x) {

        if (x < 0) return false;

        string s = to_string(x);
        return s == string(s.rbegin(), s.rend());
    }
};

int main() {

    cout << Solution().isPalindrome(121) << endl;  // true
    cout << Solution().isPalindrome(-121) << endl;  // false

    return 0;
}
