#include "MyTree.h"

/**
 * 执行用时：16 ms, 在所有 C++ 提交中击败了92.58%的用户
 * 内存消耗：20.4 MB, 在所有 C++ 提交中击败了98.41%的用户
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