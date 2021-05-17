// Created by WXX on 2021/5/17 9:19
#include "MyTree.h"

/**
 * 执行用时：0 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：10.7 MB, 在所有 C++ 提交中击败了78.20%的用户
 */
class Solution {
public:
    TreeNode *p1 = NULL, *p2 = NULL;  // x, y的父节点
    int d1 = 0, d2 = 0;  // x, y的深度

    bool isCousins(TreeNode *root, int x, int y) {
        dfs(root, 0, NULL, x, y);
        return d1 == d2 && p1 != p2;
    }

    // d: 深度; p: root的父节点
    void dfs(TreeNode *root, int d, TreeNode *p, int x, int y) {
        if (!root) return;

        if (root->val == x) d1 = d, p1 = p;
        if (root->val == y) d2 = d, p2 = p;

        if (p1 && p2) return;  // 找到x, y后提前返回
        dfs(root->left, d + 1, root, x, y);
        dfs(root->right, d + 1, root, x, y);
    }
};

int main() {

    int nu = INT_MAX;
    vector<int> nums = {
            1,
            2, 3,
            nu, 4, nu, 5
    };
    TreeNode *root = MyTree(nums).getRoot();
    cout << Solution().isCousins(root, 5, 4) << endl;  // true

    return 0;
}
