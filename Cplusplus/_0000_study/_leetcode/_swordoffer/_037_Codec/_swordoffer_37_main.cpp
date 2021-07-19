// Created by WXX on 2021/7/19 15:10
#include "MyTree.h"

class Codec {
public:
    string path;

    // Encodes a tree to a single string.
    string serialize(TreeNode *root) {
        dfs_s(root);
        return path;
    }

    void dfs_s(TreeNode *root) {
        if (!root) path += "#,";
        else {
            path += to_string(root->val) + ',';
            dfs_s(root->left);
            dfs_s(root->right);
        }
    }

    // Decodes your encoded data to tree.
    TreeNode *deserialize(string data) {
        int u = 0;
        return dfs_d(data, u);
    }

    TreeNode *dfs_d(string &s, int &u) {
        if (s[u] == '#') {
            u += 2;
            return NULL;
        }
        int k = u;
        while (s[u] != ',') u++;
        auto root = new TreeNode(stoi(s.substr(k, u - k)));
        u++;
        root->left = dfs_d(s, u);
        root->right = dfs_d(s, u);
        return root;
    }
};

int main() {

    int nu = INT_MAX;
    vector<int> nums = {
            1,
            2, 3,
            nu, nu, 4, 5
    };
    TreeNode *root = MyTree(nums).getRoot();

    Codec t = Codec();
    string s = t.serialize(root);
    cout << s << endl;  // 1,2,#,#,3,4,#,#,5,#,#,
    TreeNode *ans = t.deserialize(s);
    OutputBasicArray2D1(MyTree().levelOrder(ans));  // [[1],  [2, 3],  [4, 5]]

    return 0;
}
