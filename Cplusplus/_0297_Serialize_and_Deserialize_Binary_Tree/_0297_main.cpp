// Created by WXX on 2021/1/30 20:59
#include "MyTree.h"

/**
 * 执行用时：56 ms, 在所有 C++ 提交中击败了80.04%的用户
 * 内存消耗：30.3 MB, 在所有 C++ 提交中击败了89.28%的用户
 */
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

    // 返回反序列化后的树根，u定义为引用形式是为了让递归的时候共用一个u
    TreeNode *dfs_d(string &s, int &u) {
        if (s[u] == '#') {
            u += 2;  // 跳过#,
            return NULL;
        } else {
            int k = u;
            while (s[u] != ',') u++;
            auto root = new TreeNode(stoi(s.substr(k, u - k)));
            u++;  // 跳过,
            root->left = dfs_d(s, u);
            root->right = dfs_d(s, u);
            return root;
        }
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
