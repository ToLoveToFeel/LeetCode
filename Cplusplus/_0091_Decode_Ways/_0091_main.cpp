// Created by WXX on 2021/1/25 13:41
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：0 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：6.1 MB, 在所有 C++ 提交中击败了90.38%的用户
 */
class Solution {
public:
    int numDecodings(string s) {

        int n = s.size();
        s = ' ' + s;  // 下标从1开始，方便操作
        vector<int> f(n + 1);
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (s[i] >= '1' && s[i] <= '9') f[i] += f[i - 1];
            if (i > 1) {
                int t = (s[i - 1] - '0') * 10 + s[i] - '0';
                if (t >= 10 && t <= 26) f[i] += f[i - 2];
            }
        }
        return f[n];
    }
};

int main() {

    string s = "226";  // 3
    cout << Solution().numDecodings(s) << endl;

    return 0;
}