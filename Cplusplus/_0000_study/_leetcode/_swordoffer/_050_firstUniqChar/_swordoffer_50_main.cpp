// Created by WXX on 2021/7/19 19:47
#include <iostream>

using namespace std;

class Solution {
public:
    char firstUniqChar(string s) {
        int cnt[26] = {0};
        for (auto c : s) cnt[c - 'a']++;
        for (auto c : s)
            if (cnt[c - 'a'] == 1)
                return c;
        return ' ';
    }
};

int main() {

    cout << Solution().firstUniqChar("leetcode") << endl;  // l

    return 0;
}
