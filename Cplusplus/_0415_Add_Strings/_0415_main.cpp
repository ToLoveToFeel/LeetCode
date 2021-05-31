// Created by WXX on 2021/5/31 19:55
#include <iostream>
#include <algorithm>

using namespace std;

/**
 * 执行用时：4 ms, 在所有 C++ 提交中击败了75.29%的用户
 * 内存消耗：6.7 MB, 在所有 C++ 提交中击败了48.76%的用户
 */
class Solution {
public:
    string addStrings(string a, string b) {
        reverse(a.begin(), a.end());
        reverse(b.begin(), b.end());

        string res;
        for (int i = 0, t = 0; i < a.size() || i < b.size() || t; i++) {
            if (i < a.size()) t += a[i] - '0';
            if (i < b.size()) t += b[i] - '0';
            res += to_string(t % 10);
            t /= 10;
        }
        reverse(res.begin(), res.end());
        return res;
    }
};

int main() {

    cout << Solution().addStrings("11", "123") << endl;  // 134

    return 0;
}
