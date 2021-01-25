// Created by WXX on 2021/1/25 14:27
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：4 ms, 在所有 C++ 提交中击败了59.38%的用户
 * 内存消耗：6.4 MB, 在所有 C++ 提交中击败了98.72%的用户
 */
class Solution {
public:

    vector<string> ans;

    vector<string> restoreIpAddresses(string s) {
        dfs(s, 0, 0, "");
        return ans;
    }

    // 当前考虑到s[u]，已经得到k的数据，答案存储在path中
    void dfs(string &s, int u, int k, string path) {

        if (u == s.size()) {
            if (k == 4) {
                path.pop_back();  // 去除最后的.
                ans.push_back(path);
            }
            return;
        }
        if (k == 4) return;  // 说明当前已经得到4个数据了
        for (int i = u, t = 0; i < s.size(); i++) {  // 考虑下一个需要生成的数据
            if (i > u && s[u] == '0') break;  // 说明有前导0
            t = t * 10 + s[i] - '0';
            if (t <= 255) dfs(s, i + 1, k + 1, path + to_string(t) + '.');
            else break;
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

    string s = "101023";
    vector<string> res = Solution().restoreIpAddresses(s);
    OutputBasicArray1D(res);

    return 0;
}