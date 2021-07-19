// Created by WXX on 2021/7/19 13:56
#include "MyTree.h"

/**
 * 执行用时：0 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：11.8 MB, 在所有 C++ 提交中击败了75.62%的用户
 */
class Solution {
public:
    vector<int> levelOrder(TreeNode *root) {
        vector<int> res;
        if (!root) return res;
        queue<TreeNode *> q;
        q.push(root);
        while (q.size()) {
            auto t = q.front();
            q.pop();
            res.push_back(t->val);
            if (t->left) q.push(t->left);
            if (t->right) q.push(t->right);
        }
        return res;
    }
};

int main() {

    int nu = INT_MAX;
    vector<int> nums = {
            3,
            9, 20,
            nu, nu, 15, 7
    };
    TreeNode *root = MyTree(nums).getRoot();
    OutputBasicArray1D(Solution().levelOrder(root));

    return 0;
}
