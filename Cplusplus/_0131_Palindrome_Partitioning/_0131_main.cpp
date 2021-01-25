// Created by WXX on 2021/1/25 22:05
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:

    vector<vector<bool>> f;
    vector<vector<string>> ans;
    vector<string> path;

    vector<vector<string>> partition(string s) {

        int n = s.size();
        // 预处理：f[i][j]代表s[i...j]是否为回文串
        f = vector<vector<bool>>(n, vector<bool>(n));
        for (int j = 0; j < n; j++)
            for (int i = 0; i <= j; i++)
                if (i == j) f[i][j] = true;
                else if (s[i] == s[j]) {
                    if (i + 1 > j - 1 || f[i + 1][j - 1]) f[i][j] = true;
                }

        dfs(s, 0);
        return ans;
    }

    // 当前考察到s[u...]
    void dfs(string &s, int u) {
        if (u == s.size()) ans.push_back(path);
        else {
            for (int i = u; i < s.size(); i++) {
                if (f[u][i]) {  // 如果s[u...i]是回文串，递归求解
                    path.push_back(s.substr(u, i - u + 1));
                    dfs(s, i + 1);
                    path.pop_back();
                }
            }
        }
    }
};

void OutputBasicArray2D(vector<vector<string>> &nums) {

    cout << "[";
    for (int i = 0; i < nums.size(); i++) {
        if (i > 0 && i < nums.size()) cout << ' ';
        cout << "[";
        for (int j = 0; j < nums[i].size(); j++) {
            cout << nums[i][j];
            if (j != nums[i].size() - 1) cout << ", ";
        }
        cout << "]";
        if (i != nums.size() - 1) cout << ", " << endl;
    }
    cout << "]" << endl;
}

int main() {

    string s = "aab";
    vector<vector<string>> res = Solution().partition(s);
    OutputBasicArray2D(res);

    return 0;
}
