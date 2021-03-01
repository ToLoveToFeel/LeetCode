// Created by WXX on 2021/2/27 20:42
#include "MyTree.h"

/**
 * 执行用时：0 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：8.8 MB, 在所有 C++ 提交中击败了25.15%的用户
 */
class Solution {
public:
    vector<vector<string>> ans;

    // 返回以root为根的树的高度和宽度
    vector<int> dfs(TreeNode *root) {
        if (!root) return {0, 0};
        auto l = dfs(root->left), r = dfs(root->right);
        return {max(l[0], r[0]) + 1, max(l[1], r[1]) * 2 + 1};
    }

    // h: 层数，l：左边界，r：右边界
    void print(TreeNode *root, int h, int l, int r) {
        if (!root) return;
        int mid = (l + r) / 2;
        ans[h][mid] = to_string(root->val);
        print(root->left, h + 1, l, mid - 1);
        print(root->right, h + 1, mid + 1, r);
    }

    vector<vector<string>> printTree(TreeNode *root) {
        // 求出树的高度和宽度
        auto t = dfs(root);
        int h = t[0], w = t[1];

        ans = vector<vector<string>>(h, vector<string>(w));
        print(root, 0, 0, w - 1);
        return ans;
    }
};

int main() {

    int nu = INT_MAX;
    vector<int> nums = {
            1,
            2, 3,
            nu, 4
    };
    TreeNode *root = MyTree(nums).getRoot();
    OutputBasicArray2D((new Solution())->printTree(root));

    return 0;
}
