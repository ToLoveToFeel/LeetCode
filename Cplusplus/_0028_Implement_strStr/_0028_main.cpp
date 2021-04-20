// Created by WXX on 2021/4/20 9:39
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：0 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：7.1 MB, 在所有 C++ 提交中击败了8.43%的用户
 */
class Solution {
public:
    int strStr(string haystack, string needle) {
        if (needle.empty()) return 0;
        if (needle.size() > haystack.size()) return -1;

        int m = haystack.size(), n = needle.size();
        string s = ' ' + haystack, p = ' ' + needle;
        vector<int> ne(n + 10, 0);
        for (int i = 2, j = 0; i <= n; i++) {
            while (j && p[i] != p[j + 1]) j = ne[j];
            if (p[i] == p[j + 1]) j++;
            ne[i] = j;
        }

        for (int i = 1, j = 0; i <= m; i++) {
            while (j && s[i] != p[j + 1]) j = ne[j];
            if (s[i] == p[j + 1]) j++;
            if (j == n) return i - n;
        }
        return -1;
    }
};

int main() {

    cout << Solution().strStr("", "") << endl;  // 0
    cout << Solution().strStr("hello", "ll") << endl;  // 2
    cout << Solution().strStr("aaaaa", "bba") << endl;  // -1
    cout << Solution().strStr("mississippi", "issippi") << endl;  // 4

    return 0;
}
