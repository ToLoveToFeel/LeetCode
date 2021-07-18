// Created by WXX on 2021/7/18 17:23
#include "MyTree.h"

class Solution {
public:
    bool isSubStructure(TreeNode *A, TreeNode *B) {
        if (!A || !B) return false;
        if (isPart(A, B)) return true;  // B是A的一部分，则返回true
        return isSubStructure(A->left, B) || isSubStructure(A->right, B);
    }

    bool isPart(TreeNode *A, TreeNode *B) {
        if (!B) return true;
        if (!A || A->val != B->val) return false;
        return isPart(A->left, B->left) && isPart(A->right, B->right);
    }
};

int main() {

    int nu = INT_MAX;
    vector<int> nums1 = {
            3,
            4, 5,
            1, 2
    };
    TreeNode *A = MyTree(nums1).getRoot();
    vector<int> nums2 = {
            4,
            1, nu
    };
    TreeNode *B = MyTree(nums2).getRoot();
    cout << Solution().isSubStructure(A, B) << endl;  // true

    return 0;
}
