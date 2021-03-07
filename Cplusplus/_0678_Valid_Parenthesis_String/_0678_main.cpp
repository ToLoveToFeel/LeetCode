// Created by WXX on 2021/3/2 19:42
#include <iostream>

using namespace std;

/**
 * 执行用时：0 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：6 MB, 在所有 C++ 提交中击败了82.59%的用户
 */
class Solution {
public:
    bool checkValidString(string s) {
        int low = 0, high = 0;  // 左括号数量的范围
        for (auto c : s) {
            if (c == '(') low++, high++;
            else if (c == ')') low--, high--;
            else low--, high++;
            low = max(low, 0);
            if (low > high) return false;
        }
        return !low;
    }
};

int main() {

    cout << Solution().checkValidString("()") << endl;  // true
    cout << Solution().checkValidString("(*)") << endl;  // true
    cout << Solution().checkValidString("(*))") << endl;  // true
}
