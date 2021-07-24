// Created by WXX on 2021/7/24 9:33
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    string maximumTime(string t) {
        // 处理小时
        if (t[0] == '?' && t[1] == '?') t[0] = '2', t[1] = '3';
        else if (t[0] == '?') {
            if (t[1] <= '3') t[0] = '2';
            else t[0] = '1';
        } else if (t[1] == '?') {
            if (t[0] <= '1') t[1] = '9';
            else t[1] = '3';
        }
        // 处理分钟
        if (t[3] == '?') t[3] = '5';
        if (t[4] == '?') t[4] = '9';

        return t;
    }
};

int main() {

    cout << Solution().maximumTime("2?:?0") << endl;  // 23:50
    cout << Solution().maximumTime("0?:3?") << endl;  // 09:39
    cout << Solution().maximumTime("1?:22") << endl;  // 19:22

    return 0;
}
