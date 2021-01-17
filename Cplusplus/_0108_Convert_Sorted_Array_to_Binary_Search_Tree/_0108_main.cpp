#include "MyTree.h"

/**
 * 执行用时：24 ms, 在所有 C++ 提交中击败了83.43%的用户
 * 内存消耗：22.4 MB, 在所有 C++ 提交中击败了99.30%的用户
 */
class Solution {
public:
    TreeNode* sortedArrayToBST(vector<int>& nums) {
        return build(nums, 0, nums.size() - 1);
    }

    TreeNode* build(vector<int> &nums, int l, int r) {

        if (l > r) return NULL;
        int mid = l + r >> 1;
        TreeNode *root = new TreeNode(nums[mid]);
        root->left = build(nums, l, mid - 1);
        root->right = build(nums, mid + 1, r);
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

    vector<int> nums = {-10, -3, 0, 5, 9};
    TreeNode *root = Solution().sortedArrayToBST(nums);
    vector<vector<int>> res = MyTree().levelOrder(root);
    OutputBasicArray2D1(res);

    return 0;
}