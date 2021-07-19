// Created by WXX on 2021/7/19 21:00
#include "MyTree.h"

/**
 * 执行用时：16 ms, 在所有 C++ 提交中击败了56.15%的用户
 * 内存消耗：20.5 MB, 在所有 C++ 提交中击败了18.87%的用户
 */
class Solution {
public:
    bool ans;

    bool isBalanced(TreeNode *root) {
        ans = true;
        dfs(root);
        return ans;
    }

    int dfs(TreeNode *root) {

        if (!root) return 0;
        int lh = dfs(root->left), rh = dfs(root->right);
        if (abs(lh - rh) > 1) ans = false;
        return max(lh, rh) + 1;
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
    cout << Solution().isBalanced(root) << endl;

    return 0;
}
