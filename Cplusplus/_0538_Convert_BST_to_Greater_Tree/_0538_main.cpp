// Created by WXX on 2021/7/16 16:49
#include "MyTree.h"

/**
 * 执行用时：40 ms, 在所有 C++ 提交中击败了82.42%的用户
 * 内存消耗：32.7 MB, 在所有 C++ 提交中击败了35.57%的用户
 */
class Solution {
public:
    int sum;

    TreeNode* convertBST(TreeNode* root) {
        sum = 0;
        dfs(root);
        return root;
    }

    void dfs(TreeNode* root) {
        if (!root) return;
        dfs(root->right);

        sum += root->val;
        root->val = sum;

        dfs(root->left);
    }
};

int main() {


    return 0;
}
