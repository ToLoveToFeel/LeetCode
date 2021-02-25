// Created by WXX on 2021/2/25 21:00
#include "MyTree.h"

using namespace std;

// 树形DP
class Solution {
public:
    int rob(TreeNode *root) {
        auto f = dfs(root);
        return max(f[0], f[1]);
    }

    vector<int> dfs(TreeNode *u) {
        if (!u) return {0, 0};
        auto x = dfs(u->left), y = dfs(u->right);
        return {max(x[0], x[1]) + max(y[0], y[1]), x[0] + y[0] + u->val};
    }
};

int main() {

    int nu = INT_MAX;
    vector<int> nums = {
            3,
            2, 3,
            nu, 3, nu, 1
    };
    TreeNode *root = MyTree(nums).getRoot();
    cout << Solution().rob(root) << endl;  // 7

    return 0;
}
