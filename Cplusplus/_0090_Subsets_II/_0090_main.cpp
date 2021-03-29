// Created by WXX on 2021/3/29 15:40
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

/**
 * 执行用时：0 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：7.6 MB, 在所有 C++ 提交中击败了37.75%的用户
 */
// Leetcode 0078 子集：枚举每个数出现与否
// 本题可以枚举每个数出现的次数
class Solution {
public:
    vector<vector<int>> res;
    vector<int> path;

    vector<vector<int>> subsetsWithDup(vector<int> &nums) {

        sort(nums.begin(), nums.end());
        dfs(nums, 0);
        return res;
    }

    // u: 当前考察的是nums[u]
    void dfs(vector<int> &nums, int u) {

        if (u == nums.size()) {
            res.push_back(path);
            return;
        }

        int k = u + 1;
        while (k < nums.size() && nums[k] == nums[u]) k++;

        for (int i = 0; i <= k - u; i++) {
            dfs(nums, k);
            path.push_back(nums[u]);
        }

        for (int i = 0; i <= k - u; i++) {
            path.pop_back();
        }
    }
};

void OutputBasicArray2D(vector<vector<int>> nums) {

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

    vector<int> nums = {1, 2, 2};
    OutputBasicArray2D(Solution().subsetsWithDup(nums));

    return 0;
}
