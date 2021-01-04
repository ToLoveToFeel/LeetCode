#include <iostream>

using namespace std;

/**
 * 执行用时：144 ms, 在所有 C++ 提交中击败了60.96%的用户
 * 内存消耗：226.5 MB, 在所有 C++ 提交中击败了38.97%的用户
 */
class Solution {
private:
    // 中心扩散法, 返回回文串的长度
    int expand(string s, int l, int r) {

        while (l >= 0 && r < s.size()) {
            if (s[l] == s[r]) l--, r++;
            else break;
        }
        return r - l - 1;
    }

public:
    string longestPalindrome(string s) {

        if (s.size() < 2) return s;

        int start = 0, len = 1;
        for (int i = 0; i < s.size(); i++) {
            int cur = max(expand(s, i, i), expand(s, i, i + 1));
            if (cur > len) {
                len = cur;
                start = i - (len - 1) / 2;
            }
        }

        return s.substr(start, len);
    }
};

int main() {

    string s = "aacdefcaa";
    cout << Solution().longestPalindrome(s) << endl;

    return 0;
}
