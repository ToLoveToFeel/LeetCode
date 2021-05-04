// Created by WXX on 2021/5/4 10:44
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：4 ms, 在所有 C++ 提交中击败了82.01%的用户
 * 内存消耗：7.9 MB, 在所有 C++ 提交中击败了17.84%的用户
 */
class Solution {
public:
    string shortestPalindrome(string s) {

        string t(s.rbegin(), s.rend());  // t是s翻转后的结果
        int n = s.size();
        // KMP
        s = ' ' + s + '#' + t;
        vector<int> ne(n * 2 + 2);
        for (int i = 2, j = 0; i <= 2 * n + 1; i++) {
            while (j && s[i] != s[j + 1]) j = ne[j];
            if (s[i] == s[j + 1]) j++;
            ne[i] = j;
        }
        int len = ne[2 * n + 1];
        // left是原串中最长的前缀回文串，right是原串中去掉left的部分
        string left = s.substr(1, len), right = s.substr(1 + len, n - len);
        return string(right.rbegin(), right.rend()) + left + right;
    }
};

int main() {

    cout << Solution().shortestPalindrome("aacecaaa") << endl;  // aaacecaaa
    cout << Solution().shortestPalindrome("abcd") << endl;  // dcbabcd

    return 0;
}
