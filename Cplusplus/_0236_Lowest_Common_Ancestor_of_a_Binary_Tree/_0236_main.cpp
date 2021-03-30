// Created by WXX on 2021/3/30 19:32
#include "MyTree.h"

/**
 * 执行用时：12 ms, 在所有 C++ 提交中击败了98.30%的用户
 * 内存消耗：13.9 MB, 在所有 C++ 提交中击败了77.14%的用户
 */
class Solution {
public:
    TreeNode* ans = NULL;

    TreeNode *lowestCommonAncestor(TreeNode *root, TreeNode *p, TreeNode *q) {

        dfs(root, p, q);
        return ans;
    }

    // 返回值是一个二进制的数，最低位是1的话表示该棵子树存在p，从右向左第二位是1的话表示该棵子树存在q。
    int dfs(TreeNode *root, TreeNode *p, TreeNode *q) {

        if (!root) return 0;

        int state = dfs(root->left, p, q);
        if (root == p) state |= 1;
        else if (root == q) state |= 2;
        state |= dfs(root->right, p, q);

        if (state == 3 && !ans) ans = root;  // 只有第一次找到的才是LCA
        return state;
    }
};

int main() {


    return 0;
}
