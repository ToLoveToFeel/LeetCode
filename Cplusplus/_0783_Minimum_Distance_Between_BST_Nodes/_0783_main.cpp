// Created by WXX on 2021/4/13 8:48
#include "MyTree.h"

/**
 * 执行用时：4 ms, 在所有 C++ 提交中击败了66.07%的用户
 * 内存消耗：9.2 MB, 在所有 C++ 提交中击败了98.22%的用户
 */
class Solution {
public:
    int res = INT_MAX;
    int last;
    bool isFirst = true;

    int minDiffInBST(TreeNode *root) {
        dfs(root);
        return res;
    }

    void dfs(TreeNode *root) {

        if (!root) return;

        dfs(root->left);

        if (isFirst) isFirst = false;
        else res = min(res, root->val - last);
        last = root->val;

        dfs(root->right);
    }
};

int main() {

    int nu = INT_MAX;
    vector<int> nums = {
            1,
            nu, 3,
            nu, nu, 2
    };
    TreeNode *root = MyTree(nums).getRoot();
    cout << Solution().minDiffInBST(root) << endl;  // 1

    return 0;
}
