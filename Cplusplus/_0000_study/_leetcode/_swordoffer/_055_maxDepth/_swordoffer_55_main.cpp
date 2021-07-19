// Created by WXX on 2021/7/19 20:54
#include "MyTree.h"

/**
 * 执行用时：12 ms, 在所有 C++ 提交中击败了50.18%的用户
 * 内存消耗：18.5 MB, 在所有 C++ 提交中击败了28.74%的用户
 */
class Solution {
public:
    int maxDepth(TreeNode* root) {
        if (!root) return 0;
        return max(maxDepth(root->left), maxDepth(root->right)) + 1;
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
    cout << Solution().maxDepth(root) << endl;  // 3

    return 0;
}
