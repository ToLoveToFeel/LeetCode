// Created by WXX on 2021/7/16 10:06
#include "MyTree.h"
#include <stack>

class Solution {
public:
    void recoverTree(TreeNode* root) {
        TreeNode *first = NULL, *second = NULL, *last = NULL;
        stack<TreeNode*> stk;
        while (root || stk.size()) {
            while (root) {
                stk.push(root);
                root = root->left;
            }
            root = stk.top(); stk.pop();

            // 此处插入处理
            if (last && last->val > root->val) {
                if (!first) first = last, second = root;
                else second = root;
            }
            last = root;

            root = root->right;
        }
        swap(first->val, second->val);
    }
};

int main() {

    int nu = INT_MAX;
    vector<int> nums = {
            3,
            1, 4,
            nu, nu, 2
    };
    TreeNode *root = MyTree(nums).getRoot();
    Solution().recoverTree(root);
    OutputBasicArray2D1(MyTree().levelOrder(root));  // [[2],  [1, 4],  [3]]

    return 0;
}
