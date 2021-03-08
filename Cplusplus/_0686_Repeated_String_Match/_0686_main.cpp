// Created by WXX on 2021/3/8 10:39
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：4 ms, 在所有 C++ 提交中击败了91.30%的用户
 * 内存消耗：7.3 MB, 在所有 C++ 提交中击败了17.82%的用户
 */
class Solution {
public:
    int repeatedStringMatch(string a, string p) {

        string s;
        while (s.size() < p.size()) s += a;
        s += a;
        int n = s.size(), m = p.size();
        s = ' ' + s, p = ' ' + p;

        vector<int> next(m + 1);
        for (int i = 2, j = 0; i <= m; i++) {
            while (j && p[i] != p[j + 1]) j = next[j];
            if (p[i] == p[j + 1]) j++;
            next[i] = j;
        }
        // a/b上取整 == (a + b - 1)/b下取整
        for (int i = 1, j = 0; i <= n; i++) {
            while (j && s[i] != p[j + 1]) j = next[j];
            if (s[i] == p[j + 1]) j++;
            if (j == m) return (i + a.size() - 1) / a.size();
        }
        return -1;
    }
};

int main() {

    cout << Solution().repeatedStringMatch("abcd", "cdabcdab") << endl;  // 3
    cout << Solution().repeatedStringMatch("a", "aa") << endl;  // 2

    return 0;
}
