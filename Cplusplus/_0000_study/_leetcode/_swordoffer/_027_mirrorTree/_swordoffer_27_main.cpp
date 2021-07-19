// Created by WXX on 2021/7/19 11:06
#include "MyTree.h"

class Solution {
public:
    TreeNode* mirrorTree(TreeNode* root) {
        if (!root) return root;
        mirrorTree(root->left);
        swap(root->left, root->right);
        mirrorTree(root->left);
        return root;
    }
};

int main() {

    int nu = INT_MAX;
    vector<int> nums = {
            4,
            2, 7,
            1, 3, 6, 9
    };
    TreeNode *root = MyTree(nums).getRoot();
    OutputBasicArray2D1(MyTree().levelOrder(Solution().mirrorTree(root)));

    return 0;
}
