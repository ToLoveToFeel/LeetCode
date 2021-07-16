// Created by WXX on 2021/1/25 14:42
#include "MyTree.h"
#include <stack>

using namespace std;

// 递归
/**
 * 执行用时：0 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：8.2 MB, 在所有 C++ 提交中击败了60.90%的用户
 */
class Solution {
public:
    vector<int> res;

    vector<int> inorderTraversal(TreeNode *root) {
        dfs(root);
        return res;
    }

    void dfs(TreeNode *root) {
        if (!root) return;
        dfs(root->left);
        res.push_back(root->val);
        dfs(root->right);
    }
};

int main() {

    int nu = INT_MAX;
    vector<int> nums = {
            1,
            nu, 2,
            nu, nu, 3
    };
    TreeNode *root = MyTree(nums).getRoot();
    vector<int> res = Solution().inorderTraversal(root);
    OutputBasicArray1D(res);

    return 0;
}
// 关于机械的将递归转为非递归的做法(具有通用性)可以参考：https://www.acwing.com/solution/content/176/