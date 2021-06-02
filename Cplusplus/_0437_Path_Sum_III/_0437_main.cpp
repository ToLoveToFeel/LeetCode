// Created by WXX on 2021/6/2 10:32
#include "MyTree.h"
#include <unordered_map>

/**
 * 执行用时：12 ms, 在所有 C++ 提交中击败了97.91%的用户
 * 内存消耗：19.6 MB, 在所有 C++ 提交中击败了19.30%的用户
 */
class Solution {
public:
    unordered_map<int, int> cnt;  // (前缀和，出现的次数)
    int res = 0;

    int pathSum(TreeNode *root, int sum) {
        cnt[0]++;
        dfs(root, sum, 0);
        return res;
    }

    // cur: 前缀和
    void dfs(TreeNode *root, int sum, int cur) {
        if (!root) return;
        cur += root->val;
        res += cnt[cur - sum];
        cnt[cur]++;
        dfs(root->left, sum, cur), dfs(root->right, sum, cur);
        cnt[cur]--;
    }
};

int main() {

    int nu = INT_MAX;
    vector<int> nums = {
            10,
            5, -3,
            3, 2, nu, 11,
            3, -1, nu, 1
    };
    TreeNode *root = MyTree(nums).getRoot();
    cout << Solution().pathSum(root, 8) << endl;  // 3

    return 0;
}
