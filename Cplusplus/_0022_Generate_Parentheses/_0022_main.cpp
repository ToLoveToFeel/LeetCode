// Created by WXX on 2021/4/22 21:18
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    vector<string> ans;

    vector<string> generateParenthesis(int n) {

        dfs(n, 0, 0, "");
        return ans;
    }

    // lc: 当前使用的左括号数量, rc: 当前使用的右括号数量, seq: 当前生成的序列
    void dfs(int n, int lc, int rc, string seq) {
        if (lc == n && rc == n) ans.push_back(seq);
        else {
            if (lc < n) dfs(n, lc + 1, rc, seq + '(');
            if (rc < n && lc > rc) dfs(n, lc, rc + 1, seq + ')');
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

    OutputBasicArray1D(Solution().generateParenthesis(3));

    return 0;
}
