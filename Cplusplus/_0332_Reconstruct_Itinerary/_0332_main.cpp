// Created by WXX on 2021/2/25 19:47
#include <iostream>
#include <vector>
#include <unordered_map>
#include <set>
#include <algorithm>

using namespace std;

// 欧拉路径：所有的边走一遍（只走一次）
/**
 * 执行用时：20 ms, 在所有 C++ 提交中击败了95.56%的用户
 * 内存消耗：14 MB, 在所有 C++ 提交中击败了62.40%的用户
 */
class Solution {
public:
    unordered_map<string, multiset<string>> g;
    vector<string> ans;

    vector<string> findItinerary(vector<vector<string>> &tickets) {

        for (auto &e : tickets) g[e[0]].insert(e[1]);
        dfs("JFK");
        reverse(ans.begin(), ans.end());
        return ans;
    }

    // 回溯的路径就是欧拉路径的逆序
    void dfs(string u) {
        while (g[u].size()) {
            auto ver = *g[u].begin();
            g[u].erase(g[u].begin());
            dfs(ver);
        }
        ans.push_back(u);
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

    vector<vector<string>> tickets = {{"MUC", "LHR"},
                                      {"JFK", "MUC"},
                                      {"SFO", "SJC"},
                                      {"LHR", "SFO"}};
    OutputBasicArray1D(Solution().findItinerary(tickets));

    return 0;
}
