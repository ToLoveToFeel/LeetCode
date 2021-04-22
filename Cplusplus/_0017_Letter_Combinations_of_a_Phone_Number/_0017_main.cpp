// Created by WXX on 2021/4/22 17:45
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    vector<string> ans;  // 存储答案
    string strs[10] = {
            "", "", "abc", "def",
            "ghi", "jkl", "mno",
            "pqrs", "tuv", "wxyz",
    };

    vector<string> letterCombinations(string digits) {

        if (digits.empty()) return ans;
        dfs(digits, 0, "");
        return ans;
    }

    // 当前遍历到digits[u], 结果存储在path中
    void dfs(string digits, int u, string path) {
        if (u == digits.size()) ans.push_back(path);
        else {
            for (auto c : strs[digits[u] - '0'])
                dfs(digits, u + 1, path + c);
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

    OutputBasicArray1D(Solution().letterCombinations("234"));

    return 0;
}
