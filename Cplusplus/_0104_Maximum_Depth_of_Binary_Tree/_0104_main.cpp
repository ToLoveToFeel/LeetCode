#include "MyTree.h"

/**
 * 执行用时：4 ms, 在所有 C++ 提交中击败了99.33%的用户
 * 内存消耗：18.4 MB, 在所有 C++ 提交中击败了50.04%的用户
 */
class Solution {
public:
    int maxDepth(TreeNode *root) {

        if (!root) return 0;
        return max(maxDepth(root->left), maxDepth(root->right)) + 1;
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
    cout << Solution().maxDepth(root) << endl;

    return 0;
}