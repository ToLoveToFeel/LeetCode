// Created by WXX on 2021/2/27 21:06
#include <iostream>

using namespace std;

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
