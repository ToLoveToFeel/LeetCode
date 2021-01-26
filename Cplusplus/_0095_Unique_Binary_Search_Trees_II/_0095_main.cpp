// Created by WXX on 2021/1/25 15:02
#include "MyTree.h"

/**
 * 执行用时：8 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：15.8 MB, 在所有 C++ 提交中击败了78.28%的用户
 */
class Solution {
public:
    vector<TreeNode *> generateTrees(int n) {
        if (!n) return {};
        return dfs(1, n);
    }

    // 返回由[l...r]形成的树的树根的集合
    vector<TreeNode *> dfs(int l, int r) {

        if (l > r) return {NULL};
        vector<TreeNode *> res;

        for (int i = l; i <= r; i++) {
            auto left = dfs(l, i - 1), right = dfs(i + 1, r);
            for (auto a : left)
                for (auto b : right) {
                    auto root = new TreeNode(i);
                    root->left = a, root->right = b;
                    res.push_back(root);
                }
        }
        return res;
    }
};

int main() {

    vector<TreeNode *> res = Solution().generateTrees(3);
    for (auto root : res) {
        vector<vector<int>> ans = MyTree().levelOrder(root);
        OutputBasicArray2D1(ans);
    }

    return 0;
}
