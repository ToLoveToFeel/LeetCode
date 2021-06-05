// Created by WXX on 2021/6/5 16:44
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：20 ms, 在所有 C++ 提交中击败了63.68%的用户
 * 内存消耗：13.2 MB, 在所有 C++ 提交中击败了19.63%的用户
 */
class Solution {
public:
    bool repeatedSubstringPattern(string s) {
        int n = s.size();
        s = " " + s;
        vector<int> next(n + 1);
        for (int i = 2, j = 0; i <= n; i++) {
            while (j && s[i] != s[j + 1]) j = next[j];
            if (s[i] == s[j + 1]) j++;
            next[i] = j;
        }
        int t = n - next[n];
        return t < n && n % t == 0;
    }
};

int main() {

    cout << Solution().repeatedSubstringPattern("abab") << endl;  // true
    cout << Solution().repeatedSubstringPattern("aba") << endl;  // false

    return 0;
}
