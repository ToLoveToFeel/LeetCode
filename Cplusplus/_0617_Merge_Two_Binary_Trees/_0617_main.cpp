// Created by WXX on 2021/7/16 22:17
#include "MyTree.h"

/**
 * 执行用时：52 ms, 在所有 C++ 提交中击败了34.68%的用户
 * 内存消耗：31.5 MB, 在所有 C++ 提交中击败了78.52%的用户
 */
class Solution {
public:
    // 两棵树合并到t1上
    TreeNode* mergeTrees(TreeNode* t1, TreeNode* t2) {
        if (!t1) return t2;
        if (!t2) return t1;

        t1->val += t2->val;

        t1->left = mergeTrees(t1->left, t2->left);
        t1->right = mergeTrees(t1->right, t2->right);
        return t1;
    }
};

int main() {

    int nu = INT_MAX;
    vector<int> nums1 = {
            1,
            3, 2,
            5
    };
    TreeNode *t1 = MyTree(nums1).getRoot();
    vector<int> nums2 = {
            2,
            1, 3,
            nu, 4, nu, 7
    };
    TreeNode *t2 = MyTree(nums2).getRoot();

    TreeNode *root = Solution().mergeTrees(t1, t2);
    OutputBasicArray2D1(MyTree().levelOrder(root));  // [[3],  [4, 5],  [5, 4, 7]]

    return 0;
}
