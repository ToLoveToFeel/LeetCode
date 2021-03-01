// Created by WXX on 2021/2/27 21:06
#include <iostream>

using namespace std;

/**
 * 执行用时：8 ms, 在所有 C++ 提交中击败了95.76%的用户
 * 内存消耗：7.9 MB, 在所有 C++ 提交中击败了68.26%的用户
 */
class Solution {
public:
    bool judgeCircle(string moves) {

        int x = 0, y = 0;
        for (char c : moves) {
            if (c == 'R') y++;
            else if (c == 'L') y--;
            else if (c == 'U') x--;
            else x++;
        }
        return !x && !y;
    }
};

int main() {

    cout << Solution().judgeCircle("UD") << endl;  // true
    cout << Solution().judgeCircle("LL") << endl;  // false

    return 0;
}
