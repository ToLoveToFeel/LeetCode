// Created by WXX on 2021/2/28 13:41
#include "MyTree.h"

// 递归
/**
 * 执行用时：0 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：8.2 MB, 在所有 C++ 提交中击败了73.18%的用户
 */
class Solution {
public:
    vector<int> res;

    vector<int> preorderTraversal(TreeNode *root) {
        dfs(root);
        return res;
    }

    void dfs(TreeNode *root) {
        if (!root) return;
        res.push_back(root->val);
        dfs(root->left);
        dfs(root->right);
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
    OutputBasicArray1D(Solution().preorderTraversal(root));

    return 0;
}
