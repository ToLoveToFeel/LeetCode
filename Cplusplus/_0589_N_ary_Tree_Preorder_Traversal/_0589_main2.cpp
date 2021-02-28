// Created by WXX on 2021/2/28 17:11
#include "node.h"
#include <stack>
#include <algorithm>

// 非递归
/**
 * 执行用时：28 ms, 在所有 C++ 提交中击败了64.12%的用户
 * 内存消耗：11.2 MB, 在所有 C++ 提交中击败了72.09%的用户
 */
class Solution {
public:
    vector<int> preorder(Node *root) {
        vector<int> res;
        stack<Node *> stk;
        if (root) stk.push(root);
        while (stk.size()) {
            auto t = stk.top(); stk.pop();
            res.push_back(t->val);
            reverse(t->children.begin(), t->children.end());
            for (auto c : t->children) {
                if (c) stk.push(c);
            }
        }
        return res;
    }
};
