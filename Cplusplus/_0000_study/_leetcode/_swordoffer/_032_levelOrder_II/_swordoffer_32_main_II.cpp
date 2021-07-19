// Created by WXX on 2021/7/19 14:02
#include "MyTree.h"

class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode *root) {
        vector<vector<int>> res;
        if (!root) return res;
        queue<TreeNode *> q;
        q.push(root);
        while (q.size()) {
            int len = q.size();
            vector<int> level;
            while (len--) {
                auto t = q.front();
                q.pop();
                level.push_back(t->val);
                if (t->left) q.push(t->left);
                if (t->right) q.push(t->right);
            }
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
