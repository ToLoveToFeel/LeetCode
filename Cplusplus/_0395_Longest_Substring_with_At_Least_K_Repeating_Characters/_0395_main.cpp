// Created by WXX on 2021/2/2 22:16
#include <iostream>
#include <unordered_map>

using namespace std;

/**
 * 执行用时：36 ms, 在所有 C++ 提交中击败了17.07%的用户
 * 内存消耗：6.3 MB, 在所有 C++ 提交中击败了91.94%的用户
 */
class Solution {
public:

    int K;
    unordered_map<char, int> cnt;  // 不同字符在区间中出现的次数

    void add(char c, int &x, int &y) {
        if (!cnt[c]) x++;
        cnt[c]++;
        if (cnt[c] == K) y++;
    }

    void del(char c, int &x, int &y) {
        if (cnt[c] == K) y--;
        cnt[c]--;
        if (!cnt[c]) x--;
    }

    int longestSubstring(string s, int _K) {

        K = _K;
        int res = 0;
        // 枚举区间中最多有多少个不同的字符，这样可以使得双指针具有单调性
        for (int k = 1; k <= 26; k++) {
            cnt.clear();
            // x表示s[j...i]中不同字符的数量，y表示s[j...i]中满足字符数量大于K的字符的数量
            for (int i = 0, j = 0, x = 0, y = 0; i < s.size(); i++) {
                add(s[i], x, y);
                while (x > k) del(s[j++], x, y);
                if (x == y) res = max(res, i - j + 1);
            }
        }
        return res;
    }
};

int main() {

    cout << Solution().longestSubstring("aaabb", 3) << endl;  // 3
    cout << Solution().longestSubstring("ababbc", 2) << endl;  // 5

    return 0;
}
