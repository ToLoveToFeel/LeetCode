// Created by WXX on 2021/6/22.
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    vector<string> ans;
    vector<bool> st;

    vector<string> permutation(string s) {
        int n = s.size();
        st.resize(n);
        sort(s.begin(), s.end());
        dfs(s, 0, "");
        return ans;
    }

    void dfs(string &s, int cnt, string path) {
        if (cnt == s.size()) {
            ans.push_back(path);
            return;
        }

        for (int i = 0; i < s.size(); i++)
            if (!st[i]) {
                if (i > 0 && s[i] == s[i - 1] && !st[i - 1]) continue;
                st[i] = true;
                dfs(s, cnt + 1, path + s[i]);
                st[i] = false;
            }
    }
};

void OutputBasicArray1D(vector<string> nums) {
    cout << "[";
    for (int i = 0; i < nums.size(); i++) {
        cout << nums[i];
        if (i != nums.size() - 1) cout << ", ";
    }
    cout << "]" << endl;
}

int main() {

    OutputBasicArray1D(Solution().permutation("abc"));
    OutputBasicArray1D(Solution().permutation("aab"));

    return 0;
}
