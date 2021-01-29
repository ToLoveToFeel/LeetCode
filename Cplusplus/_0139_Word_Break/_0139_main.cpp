// Created by WXX on 2021/1/26 15:10
#include <iostream>
#include <queue>
#include <unordered_set>

using namespace std;

// 字符串哈希，动态规划
/**
 * 执行用时：4 ms, 在所有 C++ 提交中击败了97.14%的用户
 * 内存消耗：7.5 MB, 在所有 C++ 提交中击败了97.60%的用户
 */
class Solution {
public:
    bool wordBreak(string s, vector<string>& wordDict) {

        typedef unsigned long long ULL;
        const int P = 131;
        unordered_set<ULL> hash;
        for (auto &word : wordDict) {
            ULL h = 0;
            for (auto c : word) h = h * P + c;
            hash.insert(h);
        }

        int n = s.size();
        vector<bool> f(n + 1);
        f[0] = true;
        s = ' ' + s;
        for (int i = 0; i < n; i++) {
            if (f[i]) {
                ULL h = 0;
                for (int j = i + 1; j <= n; j++) {
                    h = h * P + s[j];
                    if (hash.count(h)) f[j] = true;
                }
            }
        }
        return f[n];
    }
};

int main() {

    string s = "applepenapple";
    vector<string> wordDict = {"apple", "pen"};
    cout << Solution().wordBreak(s, wordDict) << endl;  // true

    return 0;
}