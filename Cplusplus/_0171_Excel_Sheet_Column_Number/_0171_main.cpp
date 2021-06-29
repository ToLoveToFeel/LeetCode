// Created by WXX on 2021/6/29 14:21
#include <iostream>

using namespace std;

class Solution {
public:
    int titleToNumber(string s) {
        int res = 0;
        for (auto c : s) res = res * 26 + (c - 'A' + 1);
        return res;
    }
};

int main() {

    cout << Solution().titleToNumber("A") << endl;  // 1
    cout << Solution().titleToNumber("AB") << endl;  // 28
    cout << Solution().titleToNumber("ZY") << endl;  // 701

    return 0;
}
