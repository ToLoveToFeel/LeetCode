// Created by WXX on 2021/5/31 15:43
#include "MyTree.h"

/**
 * 执行用时：8 ms, 在所有 C++ 提交中击败了34.10%的用户
 * 内存消耗：13.1 MB, 在所有 C++ 提交中击败了47.45%的用户
 */
class Solution {
public:
    int res = 0;

    int sumOfLeftLeaves(TreeNode* root) {
        dfs(root);
        return res;
    }

    void dfs(TreeNode* root) {
        if (!root) return;
        if (root->left) {
            if (!root->left->left && !root->left->right)
                res += root->left->val;
        }
        dfs(root->left);
        dfs(root->right);
    }
};

int main() {

    int nu = INT_MAX;
    vector<int> nums = {
            3,
            9, 20,
            nu, nu, 15, 7
    };
    TreeNode *root = MyTree(nums).getRoot();
    cout << Solution().sumOfLeftLeaves(root) << endl;  // 24

    return 0;
}
