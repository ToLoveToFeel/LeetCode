// Created by WXX on 2021/2/28 14:28
#include "MyTree.h"
#include <stack>
#include <algorithm>

// 非递归
/**
 * 执行用时：0 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：8.1 MB, 在所有 C++ 提交中击败了94.56%的用户
 */
class Solution {
public:
    // 思路：后序遍历是：左右根，反过来就是：根右左； 按照根右左遍历后，结果再翻转一下即可
    vector<int> postorderTraversal(TreeNode *root) {
        vector<int> res;
        stack<TreeNode *> stk;
        while (root || stk.size()) {
            while (root) {
                res.push_back(root->val);
                stk.push(root);
                root = root->right;
            }
            root = stk.top()->left;
            stk.pop();
        }
        reverse(res.begin(), res.end());
        return res;
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
    OutputBasicArray1D(Solution().postorderTraversal(root));

    return 0;
}
