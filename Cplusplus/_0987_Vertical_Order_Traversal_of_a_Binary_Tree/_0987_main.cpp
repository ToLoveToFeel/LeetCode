// Created by WXX on 2021/7/31 14:58
#include "MyTree.h"
#include <map>

class Solution {
public:
    map<int, vector<vector<int>>> S;

    void dfs(TreeNode *root, int x, int y) {
        if (!root) return;

        S[y].push_back({x, root->val});
        dfs(root->left, x + 1, y - 1);
        dfs(root->right, x + 1, y + 1);
    }

    vector<vector<int>> verticalTraversal(TreeNode *root) {
        dfs(root, 0, 0);

        vector<vector<int>> res;
        for (auto &[k, v] : S) {
            sort(v.begin(), v.end());
            vector<int> col;
            for (auto &p : v) col.push_back(p[1]);
            res.push_back(col);
        }
        return res;
    }
};

int main() {

    int nu = INT_MAX;
    vector<int> nums = {
            3,
            9, 20,
            nu, nu, 15, 7
    };
    TreeNode *root = MyTree(nums).getRoot();
    OutputBasicArray2D1(Solution().verticalTraversal(root));

    return 0;
}
