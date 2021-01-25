// Created by WXX on 2021/1/25 16:48
#include "MyTree.h"

/**
 * 执行用时：16 ms, 在所有 C++ 提交中击败了70.01%的用户
 * 内存消耗：25.8 MB, 在所有 C++ 提交中击败了5.12%的用户
 */
class Solution {
public:
    bool isValidBST(TreeNode *root) {
        if (!root) return true;
        return dfs(root)[0];
    }

    // 返回的三元组：(是否为BST, 以root为根的数的最大值, 以root为根的数的最小值)
    vector<int> dfs(TreeNode *root) {
        vector<int> res({1, root->val, root->val});
        if (root->left) {
            auto t = dfs(root->left);
            if (!t[0] || t[2] >= root->val) res[0] = 0;
            res[1] = min(res[1], t[1]);
            res[2] = max(res[2], t[2]);
        }
        if (root->right) {
            auto t = dfs(root->right);
            if (!t[0] || t[1] <= root->val) res[0] = 0;
            res[1] = min(res[1], t[1]);
            res[2] = max(res[2], t[2]);
        }
        return res;
    }
};

int main() {

    int nu = INT_MAX;
    vector<int> nums = {
            2,
            1, 3
    };
    TreeNode *root = MyTree(nums).getRoot();
    cout << Solution().isValidBST(root) << endl;  // 1

    return 0;
}
