// Created by WXX on 2021/6/3 19:59
#include "MyTree.h"
#include <sstream>

/**
 * 执行用时：208 ms, 在所有 C++ 提交中击败了5.32%的用户
 * 内存消耗：363.9 MB, 在所有 C++ 提交中击败了5.14%的用户
 */
class Codec {
public:

    // Encodes a tree to a single string.
    string serialize(TreeNode* root) {
        string res;
        dfs_s(root, res);
        return res;
    }

    void dfs_s(TreeNode* root, string& res) {
        if (!root) return;
        res += to_string(root->val) + ' ';
        dfs_s(root->left, res), dfs_s(root->right, res);
    }

    // Decodes your encoded data to tree.
    TreeNode* deserialize(string str) {
        vector<int> data;
        stringstream ssin(str);
        int x, u = 0;
        while (ssin >> x) data.push_back(x);
        return dfs_d(data, u, INT_MIN, INT_MAX);
    }

    TreeNode* dfs_d(vector<int> data, int &u, int minv, int maxv) {
        if (u == data.size() || data[u] < minv || data[u] > maxv) return NULL;
        auto root = new TreeNode(data[u++]);
        root->left = dfs_d(data, u, minv, root->val);
        root->right = dfs_d(data, u, root->val + 1, maxv);
        return root;
    }
};

int main() {

    int nu = INT_MAX;
    vector<int> nums = {
            2,
            1, 3
    };
    TreeNode *root = MyTree(nums).getRoot();
    Codec t = Codec();
    string s = t.serialize(root);
    cout << s << endl;  // 2 1 3
    TreeNode *ans = t.deserialize(s);
    OutputBasicArray2D1(MyTree().levelOrder(ans));  // [[2],  [1, 3]]

    return 0;
}
