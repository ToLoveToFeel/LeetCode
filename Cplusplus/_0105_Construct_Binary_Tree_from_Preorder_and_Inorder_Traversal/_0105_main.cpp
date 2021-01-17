#include "MyTree.h"
#include <unordered_map>

/**
 * 执行用时：16 ms, 在所有 C++ 提交中击败了94.20%的用户
 * 内存消耗：17.1 MB, 在所有 C++ 提交中击败了92.84%的用户
 */
class Solution {
public:

    unordered_map<int, int> pos;  // 存储中序遍历元素对应的下标值

    TreeNode *buildTree(vector<int> &preorder, vector<int> &inorder) {

        for (int i = 0; i < inorder.size(); i++) pos[inorder[i]] = i;
        return build(preorder, inorder, 0, preorder.size() - 1, 0, inorder.size() - 1);
    }

    TreeNode *build(vector<int> &preorder, vector<int> &inorder, int pl, int pr, int il, int ir) {
        if (pl > pr) return NULL;
        auto root = new TreeNode(preorder[pl]);
        int k = pos[root->val];
        root->left = build(preorder, inorder, pl + 1, pl + 1 + k - 1 - il, il, k - 1);
        root->right = build(preorder, inorder, pl + 1 + k - 1 - il + 1, pr, k + 1, ir);
        return root;
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
    MyTree myTree = MyTree(nums);
    vector<int> preorder = myTree.preorderTraversal();
    vector<int> inorder = myTree.inorderTraversal();

    TreeNode *root = Solution().buildTree(preorder, inorder);
    vector<vector<int>> res = MyTree().levelOrder(root);
    OutputBasicArray2D1(res);

    return 0;
}