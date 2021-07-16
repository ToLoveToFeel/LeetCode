// Created by WXX on 2021/7/16 21:09
#include "MyTree.h"

/**
 * 执行用时：4 ms, 在所有 C++ 提交中击败了98.62%的用户
 * 内存消耗：19.6 MB, 在所有 C++ 提交中击败了92.48%的用户
 */
class Solution {
public:
    int ans = 0;

    int diameterOfBinaryTree(TreeNode* root) {
        dfs(root);
        return ans;
    }

    int dfs(TreeNode *root) {
        if (!root) return 0;
        int left = dfs(root->left), right = dfs(root->right);
        ans = max(ans, left + right);
        return max(left, right) + 1;
    }
};

int main() {

    int nu = INT_MAX;
    vector<int> nums = {
            1,
            2, 3,
            4, 5
    };
    TreeNode *root = MyTree(nums).getRoot();
    cout << Solution().diameterOfBinaryTree(root) << endl;  // 3

    return 0;
}
