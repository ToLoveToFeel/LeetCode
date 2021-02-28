// Created by WXX on 2021/2/28 14:26
#include "MyTree.h"

// 递归
/**
 * 执行用时：0 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：8.1 MB, 在所有 C++ 提交中击败了87.63%的用户
 */
class Solution {
public:
    vector<int> res;

    vector<int> postorderTraversal(TreeNode *root) {
        dfs(root);
        return res;
    }

    void dfs(TreeNode *root) {
        if (!root) return;
        dfs(root->left);
        dfs(root->right);
        res.push_back(root->val);
    }
};

int main() {

    int nu = INT_MAX;
    vector<int> nums = {
            1,
            nu, 2,
            nu, nu, 3
    };
    TreeNode *root = MyTree(nums).getRoot();
    OutputBasicArray1D(Solution().postorderTraversal(root));

    return 0;
}
