// Created by WXX on 2021/7/20 17:57
#include "MyTree.h"

/**
 * 执行用时：28 ms, 在所有 C++ 提交中击败了93.06%的用户
 * 内存消耗：22.7 MB, 在所有 C++ 提交中击败了67.56%的用户
 */
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if (!root) return NULL;
        if (p->val < root->val && q->val < root->val) return lowestCommonAncestor(root->left, p, q);
        if (p->val > root->val && q->val > root->val) return lowestCommonAncestor(root->right, p, q);
        return root;
    }
};

int main() {

    int nu = INT_MAX;
    vector<int> nums = {
            6,
            2, 8,
            0, 4, 7, 9,
            nu, nu, 3, 5
    };
    TreeNode *root = MyTree(nums).getRoot();
    cout << Solution().lowestCommonAncestor(root, new TreeNode(2), new TreeNode(8))->val << endl;  // 6
    cout << Solution().lowestCommonAncestor(root, new TreeNode(2), new TreeNode(4))->val << endl;  // 2

    return 0;
}
