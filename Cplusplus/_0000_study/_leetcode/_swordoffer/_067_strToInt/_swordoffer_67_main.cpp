// Created by WXX on 2021/7/20 17:49
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

/**
 * 执行用时：0 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：6.1 MB, 在所有 C++ 提交中击败了62.82%的用户
 */
class Solution {
public:
    int strToInt(string s) {
        int k = 0;
        while (k < s.size() && s[k] == ' ') k++;  // 过滤掉开始的空格
        if (k == s.size()) return 0;

        int minus = 1;  // 表示是整数还是负数
        if (s[k] == '-') minus = -1, k++;
        else if (s[k] == '+') k++;

        int res = 0;
        while (k < s.size() && s[k] >= '0' && s[k] <= '9') {
            int x = s[k] - '0';
            // 考虑边界
            if (minus > 0 && res > (INT_MAX - x) / 10) return INT_MAX;
            if (minus < 0 && -res < (INT_MIN + x) / 10) return INT_MIN;
            if (-res * 10 - x == INT_MIN) return INT_MIN;  // 本地调试不用加这句话也是正确的

            res = res * 10 + x;
            k++;
        }
        return res * minus;
    }
};

int main() {

    cout << Solution().strToInt("42") << endl;
    cout << Solution().strToInt("-2147483648") << endl;
    cout << Solution().strToInt("2147483647") << endl;

    return 0;
}
