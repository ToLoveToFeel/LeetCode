// Created by WXX on 2021/2/28 17:34
#include "node.h"

// 递归
/**
 * 执行用时：20 ms, 在所有 C++ 提交中击败了87.55%的用户
 * 内存消耗：11.3 MB, 在所有 C++ 提交中击败了61.37%的用户
 */
class Solution {
public:
    vector<int> res;

    vector<int> postorder(Node *root) {
        dfs(root);
        return res;
    }

    void dfs(Node *root) {
        if (!root) return;
        for (auto c : root->children)
            dfs(c);
        res.push_back(root->val);
    }
};
