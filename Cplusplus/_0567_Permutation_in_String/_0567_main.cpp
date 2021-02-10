// Created by WXX on 2021/2/10 9:33
#include <iostream>

using namespace std;

/**
 * 执行用时：4 ms, 在所有 C++ 提交中击败了98.95%的用户
 * 内存消耗：7.1 MB, 在所有 C++ 提交中击败了95.49%的用户
 */
class Solution {
public:
    int hash1[26], hash2[26];

    bool check(char c) {
        return hash1[c - 'a'] && hash1[c - 'a'] == hash2[c - 'a'];
    }

    bool checkInclusion(string s1, string s2) {

        int cnt1 = 0;  // 记录s1中不同字母个数
        for (auto c : s1) {
            if (hash1[c - 'a'] == 0) cnt1++;
            hash1[c - 'a']++;
        }
        // cnt表示滑动窗口内字母个数和s1中相等的字母的个数
        for (int i = 0, j = 0, cnt2 = 0; i < s2.size(); i++) {  // 滑动窗口[j...i]
            if (check(s2[i])) cnt2--;
            hash2[s2[i] - 'a']++;
            if (check(s2[i])) cnt2++;

            if (i - j >= s1.size()) {
                if (check(s2[j])) cnt2--;
                hash2[s2[j] - 'a']--;
                if (check(s2[j])) cnt2++;
                j++;
            }
            if (cnt2 == cnt1) return true;
        }
        return false;
    }
};

int main() {

    cout << Solution().checkInclusion("ab", "eidbaooo") << endl;  // true
    cout << Solution().checkInclusion("ab", "eidboaoo") << endl;  // false

    return 0;
}
