// Created by WXX on 2021/7/16 10:06
#include "MyTree.h"
#include <stack>

// Morris
/**
 * 执行用时：32 ms, 在所有 C++ 提交中击败了82.61%的用户
 * 内存消耗：56.2 MB, 在所有 C++ 提交中击败了80.73%的用户
 */
class Solution {
public:
    void recoverTree(TreeNode* root) {
        TreeNode *first = NULL, *second = NULL, *last = NULL;
        while (root) {
            if (!root->left) {  // (1)
                // 原始Morris遍历中对应输出节点的操作
                if (last && last->val > root->val) {
                    if (!first) first = last, second = root;
                    else second = root;
                }
                last = root;

                root = root->right;
            } else {  // (2)
                TreeNode *p = root->left;
                while (p->right && p->right != root) p = p->right;  // 第二个条件是因可可能是第二次遍历root的前驱

                if (!p->right) {  // (2.1)
                    p->right = root;  // root的前驱节点p的右孩子指向root, 方便回溯
                    root = root->left;
                } else {  // (2.2)
                    p->right = NULL;  // 恢复原状

                    // 原始Morris遍历中对应输出节点的操作
                    if (last && last->val > root->val) {
                        if (!first) first = last, second = root;
                        else second = root;
                    }
                    last = root;

                    root = root->right;
                }
            }
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
