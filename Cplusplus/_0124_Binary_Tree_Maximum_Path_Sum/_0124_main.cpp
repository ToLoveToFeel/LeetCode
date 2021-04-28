// Created by WXX on 2021/4/28 9:39
#include "MyTree.h"

using namespace std;

/**
 * 执行用时：32 ms, 在所有 C++ 提交中击败了54.01%的用户
 * 内存消耗：26.9 MB, 在所有 C++ 提交中击败了84.20%的用户
 */
class Solution {
public:
    int ans;

    int maxPathSum(TreeNode* root) {
        ans = INT_MIN;
        dfs(root);
        return ans;
    }

    // 返回以u为最高点的所有路径的最大值
    int dfs(TreeNode* u) {
        if (!u) return 0;
        int left = max(0, dfs(u->left)), right = max(0, dfs(u->right));
        ans = max(ans, u->val + left + right);
        return u->val + max(left, right);
    }
};

int main() {

    int nu = INT_MAX;
    vector<int> nums = {
            1,
            2, 3,
    };
    TreeNode *root = MyTree(nums).getRoot();
    cout << Solution().maxPathSum(root) << endl;  // 6

    return 0;
}
