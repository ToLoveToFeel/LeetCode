// Created by WXX on 2021/1/26 15:33
#include <iostream>
#include <vector>
#include <unordered_set>

using namespace std;

/**
 * 执行用时：16 ms, 在所有 C++ 提交中击败了84.77%的用户
 * 内存消耗：12.6 MB, 在所有 C++ 提交中击败了66.83%的用户
 */
class Solution {
public:

    vector<bool> f;  // f[i]: 表示s[i...n)是否能被wordDict中的单词划分出来
    vector<string> ans;
    unordered_set<string> hash;
    int n;

    vector<string> wordBreak(string s, vector<string> &wordDict) {

        n = s.size();
        f.resize(n + 1);
        for (auto word : wordDict) hash.insert(word);

        // 预处理出来f
        f[n] = true;
        for (int i = n - 1; ~i; i--)
            for (int j = i; j < n; j++) {
                if (hash.count(s.substr(i, j - i + 1)) && f[j + 1]) {
                    f[i] = true;
                    break;
                }
            }
        dfs(s, 0, "");
        return ans;
    }

    // u代表当前遍历到了s[u]这个字符，结果存储在path中
    void dfs(string &s, int u, string path) {

        if (u == n) {
            path.pop_back();
            ans.push_back(path);
        } else {
            for (int i = u; i < n; i++)
                if (hash.count(s.substr(u, i - u + 1)) && f[i + 1])
                    dfs(s, i + 1, path + s.substr(u, i - u + 1) + ' ');
        }
    }
};

void OutputBasicArray1D(vector<string> &nums) {
    cout << "[";
    for (int i = 0; i < nums.size(); i++) {
        cout << nums[i];
        if (i != nums.size() - 1) cout << ", ";
    }
    cout << "]" << endl;
}

int main() {

    string s = "catsanddog";
    vector<string> wordDict = {"cat", "cats", "and", "sand", "dog"};
    vector<string> res = Solution().wordBreak(s, wordDict);
    OutputBasicArray1D(res);

    return 0;
}
