// Created by WXX on 2021/6/7 8:52
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：1668 ms, 在所有 C++ 提交中击败了8.97%的用户
 * 内存消耗：8.8 MB, 在所有 C++ 提交中击败了83.01%的用户
 */
class Solution {
public:

    int ans;

    int findTargetSumWays(vector<int> &nums, int target) {
        ans = 0;
        dfs(nums, target, 0, 0);
        return ans;
    }

    void dfs(vector<int> &nums, int target, int u, int sum) {
        if (u == nums.size()) {
            if (target == sum) ans++;
            return;
        }
        // +
        dfs(nums, target, u + 1, sum + nums[u]);
        // -
        dfs(nums, target, u + 1, sum - nums[u]);
    }
};

int main() {

    vector<int> nums = {1, 1, 1, 1, 1};
    cout << Solution().findTargetSumWays(nums, 3) << endl;  // 5

    return 0;
}
