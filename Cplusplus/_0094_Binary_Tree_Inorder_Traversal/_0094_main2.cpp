// Created by WXX on 2021/2/28 14:05
#include "MyTree.h"
#include <stack>

using namespace std;

// 非递归
/**
 * 执行用时：4 ms, 在所有 C++ 提交中击败了47.82%的用户
 * 内存消耗：8.1 MB, 在所有 C++ 提交中击败了94.94%的用户
 */
class Solution {
public:
    vector<int> inorderTraversal(TreeNode *root) {
        vector<int> res;
        stack<TreeNode *> stk;
        while (root || stk.size()) {
            while (root) {
                stk.push(root);
                root = root->left;
            }
            root = stk.top(), stk.pop();
            res.push_back(root->val);
            root = root->right;
        }
        return res;
    }
};

void OutputBasicArray1D(vector<int> &nums) {
    cout << "[";
    for (int i = 0; i < nums.size(); i++) {
        cout << nums[i];
        if (i != nums.size() - 1) cout << ", ";
    }
    cout << "]" << endl;
}

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