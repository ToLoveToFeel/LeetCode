// Created by WXX on 2021/6/3 20:48
#include "MyTree.h"

/**
 * 执行用时：40 ms, 在所有 C++ 提交中击败了73.62%的用户
 * 内存消耗：31.9 MB, 在所有 C++ 提交中击败了49.91%的用户
 */
class Solution {
public:
    TreeNode* deleteNode(TreeNode* root, int key) {
        del(root, key);
        return root;
    }

    void del(TreeNode* &root, int key) {
        if (!root) return;
        if (root->val == key) {
            if (!root->left && !root->right) root = NULL;  // 叶节点，因为传递的是引用，该节点的父节点会指向空
            else if (!root->left) root = root->right;  // 只有右儿子
            else if (!root->right) root = root->left;  // 只有左儿子
            else {  // 左右儿子都有
                auto p = root->right;
                while(p->left) p = p->left;  // 找后继
                root->val = p->val;
                del(root->right, p->val);  // p最多有一个儿子
            }
        }
        else if (root->val > key) del(root->left, key);
        else del(root->right, key);
    }
};

int main() {

    int nu = INT_MAX;
    vector<int> nums = {
            5,
            3, 6,
            2, 4, nu, 7
    };
    TreeNode *root = MyTree(nums).getRoot();
    root = Solution().deleteNode(root, 3);
    OutputBasicArray2D1(MyTree().levelOrder(root));  // [[5],  [4, 6],  [2, 7]]

    return 0;
}
