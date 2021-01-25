// Created by WXX on 2021/1/25 16:58
#include "MyTree.h"

/**
 * 执行用时：0 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：9.6 MB, 在所有 C++ 提交中击败了97.94%的用户
 */
class Solution {
public:
    bool isSameTree(TreeNode *p, TreeNode *q) {

        if (!p && !q) return true;
        if (!p || !q || p->val != q->val) return false;
        return isSameTree(p->left, q->left) && isSameTree(p->right, q->right);
    }
};

int main() {

    int nu = INT_MAX;
    vector<int> nums = {
            1,
            2, 3,
    };
    TreeNode *p = MyTree(nums).getRoot();
    TreeNode *q = MyTree(nums).getRoot();
    cout << Solution().isSameTree(p, q) << endl;

    return 0;
}
