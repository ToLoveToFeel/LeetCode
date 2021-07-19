// Created by WXX on 2021/7/19 14:08
#include "MyTree.h"

/**
 * 执行用时：0 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：12.1 MB, 在所有 C++ 提交中击败了86.36%的用户
 */
class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> res;
        queue<TreeNode *> q;
        if (root) q.push(root);
        int cnt = 0;
        while (q.size()) {
            vector<int> level;
            int len = q.size();

            while (len--) {
                auto t = q.front(); q.pop();
                level.push_back(t->val);
                if (t->left) q.push(t->left);
                if (t->right) q.push(t->right);
            }

            if (++cnt % 2 == 0) reverse(level.begin(), level.end());
            res.push_back(level);
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
    OutputBasicArray2D1(Solution().levelOrder(root));

    return 0;
}
