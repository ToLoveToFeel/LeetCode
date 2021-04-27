// Created by WXX on 2021/4/27 9:28
#include "MyTree.h"
#include <stack>

class Solution {
public:
    int rangeSumBST(TreeNode *root, int low, int high) {

        int res = 0;
        stack<TreeNode *> stk;
        while (root || stk.size()) {
            while (root) {
                stk.push(root);
                root = root->left;
            }
            root = stk.top();
            stk.pop();
            if (root->val >= low && root->val <= high) res += root->val;
            root = root->right;
        }
        return res;
    }
};

int main() {

    int nu = INT_MAX;
    vector<int> nums = {
            10,
            5, 15,
            3, 7, nu, 18
    };
    TreeNode *root = MyTree(nums).getRoot();
    cout << Solution().rangeSumBST(root, 7, 15) << endl;  // 32

    return 0;
}
