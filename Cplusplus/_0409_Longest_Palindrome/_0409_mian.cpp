// Created by WXX on 2021/5/31 16:23
#include <iostream>
#include <unordered_map>

using namespace std;

class Solution {
public:
    int longestPalindrome(string s) {
        unordered_map<char, int> hash;
        for (auto c : s) hash[c]++;
        int res = 0;
        for (auto &[k, v] : hash) res += v / 2 * 2;
        if (res < s.size()) res++;
        return res;
    }
};

int main() {

    cout << Solution().longestPalindrome("abccccdd") << endl;  // 7

    return 0;
}
