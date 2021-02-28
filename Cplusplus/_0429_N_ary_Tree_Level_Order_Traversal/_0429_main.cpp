// Created by WXX on 2021/2/28 18:10
#include "node.h"
#include <queue>

/**
 * 执行用时：20 ms, 在所有 C++ 提交中击败了84.18%的用户
 * 内存消耗：11.4 MB, 在所有 C++ 提交中击败了97.76%的用户
 */
class Solution {
public:
    vector<vector<int>> levelOrder(Node *root) {

        vector<vector<int>> res;
        if (!root) return res;
        queue<Node *> q;
        q.push(root);
        while (q.size()) {
            int len = q.size();
            vector<int> line;
            while (len--) {
                auto t = q.front(); q.pop();
                line.push_back(t->val);
                for (auto c : t->children)
                    q.push(c);
            }
            res.push_back(line);
        }
        return res;
    }
};
