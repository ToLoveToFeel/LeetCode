#include "MyTree.h"
#include <unordered_map>

/**
 * 执行用时：20 ms, 在所有 C++ 提交中击败了84.03%的用户
 * 内存消耗：17.2 MB, 在所有 C++ 提交中击败了92.27%的用户
 */
class Solution {
public:

    unordered_map<int, int> pos;  // 存储中序遍历元素对应的下标值

    TreeNode *buildTree(vector<int> &inorder, vector<int> &postorder) {

        for (int i = 0; i < inorder.size(); i++) pos[inorder[i]] = i;
        return build(inorder, postorder, 0, inorder.size() - 1, 0, postorder.size() - 1);
    }

    TreeNode *build(vector<int> &inorder, vector<int> &postorder, int il, int ir, int pl, int pr) {
        if (il > ir) return NULL;
        auto root = new TreeNode(postorder[pr]);
        int k = pos[root->val];
        root->left = build(inorder, postorder, il, k - 1, pl, pl + k - 1 - il);
        root->right = build(inorder, postorder, k + 1, ir, pl + k - 1 - il + 1, pr - 1);
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
    vector<int> inorder = myTree.inorder();
    vector<int> postorder = myTree.postorder();

    TreeNode *root = Solution().buildTree(inorder, postorder);
    vector<vector<int>> res = MyTree().levelOrder(root);
    OutputBasicArray2D1(res);

    return 0;
}