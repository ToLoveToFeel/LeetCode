// Created by WXX on 2021/2/2 11:32
#include <iostream>

using namespace std;

/**
 * 执行用时：24 ms, 在所有 C++ 提交中击败了38.89%的用户
 * 内存消耗：6.7 MB, 在所有 C++ 提交中击败了99.88%的用户
 */
class Solution {
public:
    int characterReplacement(string s, int k) {

        int res = 0;
        for (char c = 'A'; c <= 'Z'; c++) {
            // 滑动窗口[j...i]
            for (int i = 0, j = 0, cnt = 0; i < s.size(); i++) {
                if (s[i] == c) cnt++;
                while (i - j + 1 - cnt > k) {
                    if (s[j] == c) cnt--;
                    j++;
                }
                res = max(res, i - j + 1);
            }
        }
        return res;
    }
};

int main() {

    cout << Solution().characterReplacement("ABAB", 2) << endl;  // 4
    cout << Solution().characterReplacement("AABABBA", 1) << endl;  // 4

    return 0;
}
