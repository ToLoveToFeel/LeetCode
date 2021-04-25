// Created by WXX on 2021/4/25 10:26
#include "MyTree.h"
#include <stack>

/**
 * 执行用时：0 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：7.8 MB, 在所有 C++ 提交中击败了28.18%的用户
 */
class Solution {
public:
    TreeNode *increasingBST(TreeNode *root) {

        // (1) 将中序遍历结果存入数组中
        vector<int> nums;
        stack<TreeNode *> stk;
        while (root || stk.size()) {
            while (root) {
                stk.push(root);
                root = root->left;
            }
            root = stk.top(); stk.pop();
            nums.push_back(root->val);
            root = root->right;
        }
        // (2) 根据中序遍历结果构建增顺序搜索树
        auto dummy = new TreeNode(-1), cur = dummy;
        for (int i = 0; i < nums.size(); i++) {
            cur->right = new TreeNode(nums[i]);
            cur = cur->right;
        }
        return dummy->right;
    }
};

int main() {

    int nu = INT_MAX;
    vector<int> nums = {
            5,
            1, 7,
    };
    TreeNode *root = MyTree(nums).getRoot();
    OutputBasicArray2D1(MyTree().levelOrder(Solution().increasingBST(root)));

    return 0;
}
