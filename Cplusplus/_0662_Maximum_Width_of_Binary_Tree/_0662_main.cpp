// Created by WXX on 2021/2/27 22:32
#include "MyTree.h"

// 如果当前节点编号为p，则其左孩子编号为2*p，右儿子为2*p+1
// 为了防止层数过多，编号报int，因此遍历每一层时，如果遍历到t
// 将下一层需要插入的数据变为: (t-该层第一个数据+1) * 2 / (t-该层第一个数据+1) * 2 + 1
/**
 * 执行用时：8 ms, 在所有 C++ 提交中击败了77.36%的用户
 * 内存消耗：15.9 MB, 在所有 C++ 提交中击败了74.88%的用户
 */
class Solution {
public:
    int widthOfBinaryTree(TreeNode* root) {

        if (!root) return 0;
        queue<pair<TreeNode*, int>> q;
        q.push({root, 1});
        int res = 1;
        while (q.size()) {
            int sz = q.size();
            int l = q.front().second, r = 0;

            for (int i = 0; i < sz; i++) {
                auto t = q.front(); q.pop();
                auto v = t.first;
                auto p = t.second - l + 1;
                r = t.second;
                if (v->left) q.push({v->left, p * 2});
                if (v->right) q.push({v->right, p * 2 + 1});
            }
            res = max(res, r - l + 1);
        }
        return res;
    }
};

int main() {

    int nu = INT_MAX;
    vector<int> nums = {
            1,
            3, 2,
            5, nu, nu, 9,
            6, nu, nu, nu, nu, nu, nu, 7
    };
    TreeNode *root = MyTree(nums).getRoot();
    cout << Solution().widthOfBinaryTree(root) << endl;  // 8

    return 0;
}
