// Created by WXX on 2021/7/8 22:04
#include "MyTree.h"

/**
 * 执行用时：20 ms, 在所有 C++ 提交中击败了15.01%的用户
 * 内存消耗：26.9 MB, 在所有 C++ 提交中击败了5.04%的用户
 */
class Solution {
public:
    const int INF = 1e8;  // 表示不合法

    vector<int> dfs(TreeNode *root) {
        if (!root) return {0, 0, INF};
        auto l = dfs(root->left), r = dfs(root->right);
        return {
                min(l[1], l[2]) + min(r[1], r[2]),
                min(l[2] + min(r[1], r[2]), r[2] + min(l[1], l[2])),
                min(l[0], min(l[1], l[2])) + min(r[0], min(r[1], r[2])) + 1,
        };
    }

    int minCameraCover(TreeNode *root) {
        auto f = dfs(root);
        return min(f[1], f[2]);
    }
};

int main() {

    int nu = INT_MAX;
    vector<int> nums = {
            1,
            1, nu,
            1, 1,
    };
    TreeNode *root = MyTree(nums).getRoot();
    cout << Solution().minCameraCover(root) << endl;  // 1

    return 0;
}
