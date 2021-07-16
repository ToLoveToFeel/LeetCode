// Created by WXX on 2021/2/28 14:28
#include "MyTree.h"
#include <stack>
#include <algorithm>

// Morris
/**
 * 可以首先按照**根右左**的顺序遍历整棵树，最后将结果翻转一下即可。
 * 因此此写法和`Morris`前序遍历相同，区别在于`left`和`right`全部交换即可。
 */
class Solution {
public:
    // 思路：后序遍历是：左右根，反过来就是：根右左； 按照根右左遍历后，结果再翻转一下即可
    vector<int> postorderTraversal(TreeNode *root) {
        vector<int> res;
        while (root) {
            if (!root->right) {
                res.push_back(root->val);
                root = root->left;
            } else {
                TreeNode *p = root->right;
                while (p->left && p->left != root) p = p->left;

                if (!p->left) {
                    p->left = root;
                    res.push_back(root->val);
                    root = root->right;
                } else {
                    p->left = NULL;
                    root = root->left;
                }
            }
        }
        reverse(res.begin(), res.end());
        return res;
    }
};

int main() {

    int nu = INT_MAX;
    vector<int> nums = {
            1,
            nu, 2,
            nu, nu, 3
    };
    TreeNode *root = MyTree(nums).getRoot();
    OutputBasicArray1D(Solution().postorderTraversal(root));

    return 0;
}
