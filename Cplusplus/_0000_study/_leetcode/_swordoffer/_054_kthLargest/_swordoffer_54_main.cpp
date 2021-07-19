// Created by WXX on 2021/7/19 20:46
#include "MyTree.h"

/**
 * 执行用时：8 ms, 在所有 C++ 提交中击败了99.74%的用户
 * 内存消耗：23.4 MB, 在所有 C++ 提交中击败了85.63%的用户
 */
class Solution {
public:
    int ans;

    int kthLargest(TreeNode* root, int k) {
        dfs(root, k);
        return ans;
    }

    void dfs(TreeNode* root, int &k) {
        if (!root) return;

        dfs(root->right, k);
        k--;
        if (!k) ans = root->val;
        if (k > 0) dfs(root->left, k);
    }
};

int main() {

    int nu = INT_MAX;
    vector<int> nums = {
            3,
            1, 4,
            nu, 2
    };
    TreeNode *root = MyTree(nums).getRoot();
    cout << Solution().kthLargest(root, 1) << endl;  // 4

    return 0;
}
