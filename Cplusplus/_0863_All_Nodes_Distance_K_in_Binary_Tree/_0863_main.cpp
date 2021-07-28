// Created by WXX on 2021/7/28 9:10
#include "MyTree.h"
#include <unordered_map>

/**
 * 执行用时：8 ms, 在所有 C++ 提交中击败了58.35%的用户
 * 内存消耗：16.8 MB, 在所有 C++ 提交中击败了7.59%的用户
 */
class Solution {
public:
    unordered_map<TreeNode *, vector<TreeNode *>> g;
    vector<int> ans;

    void dfs1(TreeNode *root) {
        if (root->left) {
            g[root].push_back(root->left);
            g[root->left].push_back(root);
            dfs1(root->left);
        }
        if (root->right) {
            g[root].push_back(root->right);
            g[root->right].push_back(root);
            dfs1(root->right);
        }
    }

    void dfs2(TreeNode *root, TreeNode *father, int k) {
        if (!k) ans.push_back(root->val);
        else {
            for (auto son : g[root])
                if (son && son != father)
                    dfs2(son, root, k - 1);
        }
    }

    vector<int> distanceK(TreeNode *root, TreeNode *target, int k) {
        dfs1(root);
        dfs2(target, NULL, k);
        return ans;
    }
};

int main() {

    int nu = INT_MAX;
    vector<int> nums = {
            3,
            5, 1,
            6, 2, 0, 8,
            nu, nu, 7, 4
    };
    TreeNode *root = MyTree(nums).getRoot();
    TreeNode *target = root->left;
    OutputBasicArray1D(Solution().distanceK(root, target, 2));  // [1, 7, 4]

    return 0;
}
