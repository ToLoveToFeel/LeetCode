// Created by WXX on 2021/8/20 9:51
#include <iostream>
#include <algorithm>

using namespace std;

/**
 * 执行用时：0 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：7 MB, 在所有 C++ 提交中击败了88.96%的用户
 */
class Solution {
public:
    string reverseStr(string s, int k) {
        for (int i = 0; i < s.size(); i += 2 * k) {
            if (i + k >= s.size()) reverse(s.begin() + i, s.end());
            else reverse(s.begin() + i, s.begin() + i + k);
        }
        return s;
    }
};

int main() {

    cout << Solution().reverseStr("abcd", 3) << endl;  // cbad
    cout << Solution().reverseStr("abcd", 4) << endl;  // dcba
    cout << Solution().reverseStr("abcd", 5) << endl;  // dcba

    return 0;
}
