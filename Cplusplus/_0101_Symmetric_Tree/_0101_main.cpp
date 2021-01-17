#include "MyTree.h"

/**
 * 执行用时：8 ms, 在所有 C++ 提交中击败了44.38%的用户
 * 内存消耗：11.9 MB, 在所有 C++ 提交中击败了99.99%的用户
 */
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

    vector<int> nums = {
            1,
            2, 2,
            3, 4, 4, 3
    };
    TreeNode *root = MyTree(nums).getRoot();
    cout << Solution().isSymmetric(root) << endl;

    return 0;
}