// Created by WXX on 2021/3/2 16:16
#include "MyTree.h"

/**
 * 执行用时：4 ms, 在所有 C++ 提交中击败了32.12%的用户
 * 内存消耗：6.8 MB, 在所有 C++ 提交中击败了90.58%的用户
 */
class Solution {
public:
    long long d1, d2;  // d1存储最小数，d2存储第二小数

    void dfs(TreeNode *root) {
        if (!root) return;
        int x = root->val;
        if (x < d1) d2 = d1, d1 = x;
        else if (x > d1 && x < d2) d2 = x;
        dfs(root->left), dfs(root->right);
    }

    int findSecondMinimumValue(TreeNode *root) {
        d1 = d2 = 1e18;
        dfs(root);
        if (d2 == 1e18) d2 = -1;
        return d2;
    }
};

int main() {

    int nu = INT_MAX;
    vector<int> nums = {
            2,
            2, 5,
            nu, nu, 5, 7
    };
    TreeNode *root = MyTree(nums).getRoot();
    cout << Solution().findSecondMinimumValue(root) << endl;  // 5

    return 0;
}
