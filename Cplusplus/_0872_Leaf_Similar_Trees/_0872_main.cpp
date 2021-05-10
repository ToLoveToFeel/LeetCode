// Created by WXX on 2021/5/10 10:41
#include "MyTree.h"

class Solution {
public:
    bool leafSimilar(TreeNode *root1, TreeNode *root2) {
        vector<int> seq1, seq2;
        dfs(root1, seq1), dfs(root2, seq2);
        return seq1 == seq2;
    }

    void dfs(TreeNode *root, vector<int> &seq) {
        if (!root) return;
        if (!root->left && !root->right) seq.push_back(root->val);
        dfs(root->left, seq);
        dfs(root->right, seq);
    }
};

int main() {

    int nu = INT_MAX;
    vector<int> nums1 = {
            1,
            2, 3,
    };
    TreeNode *root1 = MyTree(nums1).getRoot();
    vector<int> nums2 = {
            1,
            3, 2,
    };
    TreeNode *root2 = MyTree(nums2).getRoot();
    cout << Solution().leafSimilar(root1, root2) << endl;  // false

    return 0;
}
