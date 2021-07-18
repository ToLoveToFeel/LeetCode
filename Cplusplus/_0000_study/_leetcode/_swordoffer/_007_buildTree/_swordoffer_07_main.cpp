// Created by WXX on 2021/7/18 14:38
#include "MyTree.h"
#include <unordered_map>

class Solution {
public:
    unordered_map<int, int> pos;

    TreeNode *buildTree(vector<int> &preorder, vector<int> &inorder) {
        for (int i = 0; i < inorder.size(); i++) pos[inorder[i]] = i;
        return build(preorder, inorder, 0, preorder.size() - 1, 0, inorder.size() - 1);
    }

    TreeNode *build(vector<int> &preorder, vector<int> &inorder, int pl, int pr, int il, int ir) {
        if (pl > pr) return NULL;
        int k = pos[preorder[pl]];
        auto root = new TreeNode(inorder[k]);
        root->left = build(preorder, inorder, pl + 1, pl + 1 + k - 1 - il, il, k - 1);
        root->right = build(preorder, inorder, pl + 1 + k - 1 - il + 1, pr, k + 1, ir);
        return root;
    }
};

int main() {

    vector<int> preorder = {3, 9, 20, 15, 7}, inorder = {9, 3, 15, 20, 7};
    OutputBasicArray2D1(MyTree().levelOrder(Solution().buildTree(preorder, inorder)));

    return 0;
}
