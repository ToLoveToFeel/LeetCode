#include "MyTree.h"

/**
 * 执行用时：4 ms, 在所有 C++ 提交中击败了89.06%的用户
 * 内存消耗：11.3 MB, 在所有 C++ 提交中击败了97.27%的用户
 */
class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode *root) {

        vector<vector<int>> res;
        queue<TreeNode *> q;
        if (root) q.push(root);
        while (q.size()) {
            vector<int> level;
            int len = q.size();

            while (len--) {
                auto t = q.front();
                q.pop();
                level.push_back(t->val);
                if (t->left) q.push(t->left);
                if (t->right) q.push(t->right);
            }
            res.push_back(level);
        }
        return res;
    }
};

void OutputBasicArray2D1(vector<vector<int>> &nums) {

    cout << "[";
    for (int i = 0; i < nums.size(); i++) {
        if (i > 0 && i < nums.size()) cout << ' ';
        cout << "[";
        for (int j = 0; j < nums[i].size(); j++) {
            cout << nums[i][j];
            if (j != nums[i].size() - 1) cout << ", ";
        }
        cout << "]";
        if (i != nums.size() - 1) cout << ", ";
    }
    cout << "]" << endl;
}

int main() {

    int nu = INT_MAX;
    vector<int> nums = {
            3,
            9, 20,
            nu, nu, 15, 7
    };
    TreeNode *root = MyTree(nums).getRoot();
    vector<vector<int>> res = Solution().levelOrder(root);
    OutputBasicArray2D1(res);

    return 0;
}