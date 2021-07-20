// Created by WXX on 2021/7/20 17:57
#include "MyTree.h"

/**
 * 执行用时：8 ms, 在所有 C++ 提交中击败了99.77%的用户
 * 内存消耗：13.9 MB, 在所有 C++ 提交中击败了67.51%的用户
 */
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if (!root || root == p || root == q) return root;
        auto l = lowestCommonAncestor(root->left, p, q), r = lowestCommonAncestor(root->right, p, q);
        if (l && r) return root;  // 第一次左右非空, 此时对应的root是LCA
        if (l) return l;
        return r;  // right也可能为空节点
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
