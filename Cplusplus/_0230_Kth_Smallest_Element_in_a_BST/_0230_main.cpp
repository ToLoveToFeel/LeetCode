// Created by WXX on 2021/5/4 17:43
#include "MyTree.h"
#include <stack>

class Solution {
public:
    int kthSmallest(TreeNode *root, int k) {
        int cnt = 1;
        stack<TreeNode *> stk;
        while (root || stk.size()) {
            while (root) {
                stk.push(root);
                root = root->left;
            }
            auto t = stk.top(); stk.pop();
            if (cnt++ == k) return t->val;
            root = t->right;
        }
        return -1;  // 一定不会被执行
    }
};

int main() {

    int nu = INT_MAX;
    vector<int> nums = {
            3,
            1, 4,
            nu, 2,
    };
    TreeNode *root = MyTree(nums).getRoot();
    cout << Solution().kthSmallest(root, 1) << endl;  // 1

    return 0;
}
