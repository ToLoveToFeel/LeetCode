// Created by WXX on 2021/2/28 17:11
#include "node.h"

// 递归
/**
 * 执行用时：16 ms, 在所有 C++ 提交中击败了96.71%的用户
 * 内存消耗：11.3 MB, 在所有 C++ 提交中击败了62.70%的用户
 */
class Solution {
public:
    vector<int> res;

    vector<int> preorder(Node *root) {
        dfs(root);
        return res;
    }

    void dfs(Node *root) {
        if (!root) return;
        res.push_back(root->val);
        for (auto c : root->children)
            dfs(c);
    }
};
