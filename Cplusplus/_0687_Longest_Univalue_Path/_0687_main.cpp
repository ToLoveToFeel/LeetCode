// Created by WXX on 2021/3/10 19:30
#include "MyTree.h"

/**
 * 执行用时：152 ms, 在所有 C++ 提交中击败了82.97%的用户
 * 内存消耗：70.1 MB, 在所有 C++ 提交中击败了66.76%的用户
 */
class Solution {
public:
    int ans;

    int longestUnivaluePath(TreeNode *root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    // 返回以root为最高点的最长等值路径
    int dfs(TreeNode *root) {
        if (!root) return 0;
        int l = dfs(root->left), r = dfs(root->right);
        if (root->left && root->left->val != root->val) l = 0;
        if (root->right && root->right->val != root->val) r = 0;
        ans = max(ans, l + r);
        return max(l, r) + 1;
    }
};

int main() {

    int nu = INT_MAX;
    vector<int> nums = {
            1,
            4, 5,
            4, 4, nu, 5
    };
    TreeNode *root = MyTree(nums).getRoot();
    cout << Solution().longestUnivaluePath(root) << endl;

    return 0;
}
