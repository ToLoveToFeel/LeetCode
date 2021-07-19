// Created by WXX on 2021/7/19 14:47
#include "MyTree.h"

/**
 * 执行用时：12 ms, 在所有 C++ 提交中击败了60.82%的用户
 * 内存消耗：36.3 MB, 在所有 C++ 提交中击败了10.85%的用户
 */
class Solution {
public:
    vector<vector<int>> ans;

    vector<vector<int>> pathSum(TreeNode* root, int target) {
        vector<int> path;
        dfs(root, target, path);
        return ans;
    }

    void dfs(TreeNode* root, int target, vector<int> path) {
        if (!root) return;

        path.push_back(root->val);
        target -= root->val;
        if (!root->left && !root->right) {
            if (!target) ans.push_back(path);
            return;
        }

        dfs(root->left, target, path);
        dfs(root->right, target, path);
    }
};

int main() {

    int nu = INT_MAX;
    vector<int> nums = {
            5,
            4, 8,
            11, nu, 13, 4,
            7, 2, nu, nu, nu, nu, 5, 1
    };
    TreeNode *root = MyTree(nums).getRoot();
    OutputBasicArray2D1(Solution().pathSum(root, 22));  // [[5, 4, 11, 2],  [5, 8, 4, 5]]

    return 0;
}
