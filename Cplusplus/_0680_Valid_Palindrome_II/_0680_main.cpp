// Created by WXX on 2021/3/7 20:14
#include <iostream>

using namespace std;

// 思路：双指针，如果遇到不相同的位置，可以尝试跳过左边的或者右边的
// 如果存在这样的回文串，我们的算法一定可以找到
/**
 * 执行用时：52 ms, 在所有 C++ 提交中击败了71.46%的用户
 * 内存消耗：19.1 MB, 在所有 C++ 提交中击败了91.75%的用户
 */
class Solution {
public:
    bool check(string &s, int i, int j) {
        while (i < j) {
            if (s[i] != s[j]) return false;
            i++, j--;
        }
        return true;
    }

    bool validPalindrome(string s) {
        for (int i = 0, j = s.size() - 1; i < j; i++, j--)
            if (s[i] != s[j]) {
                return check(s, i + 1, j) || check(s, i, j - 1);
            }
        return true;
    }
};

int main() {

    cout << Solution().validPalindrome("aba") << endl;  // true
    cout << Solution().validPalindrome("abca") << endl;  // true

    return 0;
}
