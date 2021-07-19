// Created by WXX on 2021/7/19 11:13
#include "MyTree.h"

class Solution {
public:
    bool isSymmetric(TreeNode *root) {
        if (!root) return true;
        return dfs(root->left, root->right);
    }

    bool dfs(TreeNode *p, TreeNode *q) {
        if (!p && !q) return true;
        if (!p || !q || p->val != q->val) return false;
        return dfs(p->left, q->right) && dfs(p->right, q->left);
    }
};

int main() {

    int nu = INT_MAX;
    vector<int> nums = {
            1,
            2, 2,
            3, 4, 4, 3
    };
    TreeNode *root = MyTree(nums).getRoot();
    cout << Solution().isSymmetric(root) << endl;  // true

    return 0;
}
