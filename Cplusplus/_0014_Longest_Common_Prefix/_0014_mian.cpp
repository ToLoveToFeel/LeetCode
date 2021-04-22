// Created by WXX on 2021/4/22 16:05
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    string longestCommonPrefix(vector<string> &strs) {

        string res;
        if (strs.empty()) return res;

        for (int i = 0; i < strs[0].size(); i++) {
            char c = strs[0][i];
            for (auto &s : strs)
                if (i >= s.size() || s[i] != c)
                    return res;
            res += c;
        }
        return res;
    }
};

int main() {

    vector<string> strs = {"flower", "flow", "flight"};
    cout << Solution().longestCommonPrefix(strs) << endl;

    return 0;
}
