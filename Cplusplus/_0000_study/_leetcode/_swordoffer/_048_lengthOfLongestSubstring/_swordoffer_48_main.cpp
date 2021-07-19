// Created by WXX on 2021/7/19 19:33
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：8 ms, 在所有 C++ 提交中击败了88.62%的用户
 * 内存消耗：7.5 MB, 在所有 C++ 提交中击败了75.47%的用户
 */
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int res = 0;
        vector<int> cnt(128);
        for (int i = 0, j = 0; i < s.size(); i++) {
            cnt[s[i]]++;
            while (cnt[s[i]] > 1) cnt[s[j++]]--;
            res = max(res, i - j + 1);
        }
        return res;
    }
};

int main() {

    cout << Solution().lengthOfLongestSubstring("abcabcbb") << endl;  // 3

    return 0;
}
