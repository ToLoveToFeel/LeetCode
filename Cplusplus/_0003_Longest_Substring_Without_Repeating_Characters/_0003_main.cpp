#include <iostream>
#include <string>
#include <unordered_map>

using namespace std;

/**
 * 滑动窗口
 * 执行用时：36 ms, 在所有 C++ 提交中击败了67.13%的用户
 * 内存消耗：8.6 MB, 在所有 C++ 提交中击败了55.16%的用户
 */
class Solution {
public:
    int lengthOfLongestSubstring(string s) {

        unordered_map<char, int> map;
        int res = 0;
        for (int i = 0, j = 0; i < s.size(); i++) {
            map[s[i]]++;
            while (map[s[i]] > 1) map[s[j++]]--;
            res = max(res, i - j + 1);
        }
        return res;
    }
};

int main() {

    cout << Solution().lengthOfLongestSubstring("abcabcbb") << endl; // 3
    cout << Solution().lengthOfLongestSubstring("pwwkew") << endl;   // 3
    cout << Solution().lengthOfLongestSubstring("c") << endl;        // 1
    cout << Solution().lengthOfLongestSubstring("") << endl;         // 0

    return 0;
}
