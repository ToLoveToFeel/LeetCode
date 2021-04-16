// Created by WXX on 2021/4/16 9:24
#include <iostream>
#include <algorithm>
#include <cstring>

using namespace std;

// 动态规划
/**
 * 执行用时：12 ms, 在所有 C++ 提交中击败了66.20%的用户
 * 内存消耗：6.1 MB, 在所有 C++ 提交中击败了94.62%的用户
 */
class Solution {
public:
    bool isScramble(string s1, string s2) {

        int n = s1.size();
        // 初始化状态
        bool f[n][n][n + 1];
        memset(f, 0, sizeof f);  // 没有这句话lc报错
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                f[i][j][1] = (s1[i] == s2[j]);
        // 状态转移
        for (int len = 2; len <= n; len++)  // 遍历长度
            for (int i = 0; i + len - 1 < n; i++)  // 遍历s1的起点
                for (int j = 0; j + len - 1 < n; j++)  // 遍历s2的起点
                    for (int k = 1; k < len; k++) {
                        if (f[i][j][k] && f[i + k][j + k][len - k]) {
                            f[i][j][len] = true;
                            break;
                        }
                        if (f[i][j + len - k][k] && f[i + k][j][len - k]) {
                            f[i][j][len] = true;
                            break;
                        }
                    }
        return f[0][0][n];
    }
};

int main() {

    cout << Solution().isScramble("great", "rgeat") << endl;  // true

    return 0;
}
