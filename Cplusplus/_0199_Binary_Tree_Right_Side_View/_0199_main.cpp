// Created by WXX on 2021/1/26 16:54
#include "MyTree.h"

/**
 * 执行用时：4 ms, 在所有 C++ 提交中击败了81.28%的用户
 * 内存消耗：11.4 MB, 在所有 C++ 提交中击败了95.64%的用户
 */
class Solution {
public:
    vector<int> rightSideView(TreeNode *root) {

        if (root == NULL) return {};
        vector<int> res;
        queue<TreeNode *> q;
        q.push(root);
        while (q.size()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                auto t = q.front();
                q.pop();
                if (t->left) q.push(t->left);
                if (t->right) q.push(t->right);
                if (i == len - 1) res.push_back(t->val);
            }
        }
        return res;
    }
};

int main() {

    int nu = INT_MAX;
    vector<int> nums = {
            1,
            2, 3,
            nu, 5, nu, 4,
    };
    TreeNode *root = MyTree(nums).getRoot();
    vector<int> res = Solution().rightSideView(root);
    OutputBasicArray1D(res);

    return 0;
}
