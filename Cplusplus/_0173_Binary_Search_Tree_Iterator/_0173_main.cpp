// Created by WXX on 2021/3/28 10:16
#include "MyTree.h"

using namespace std;

class BSTIterator {
public:
    vector<int> nums;
    int k;

    void dfs(TreeNode *root) {
        if (!root) return;
        dfs(root->left);
        nums.push_back(root->val);
        dfs(root->right);
    }

    BSTIterator(TreeNode *root) {
        dfs(root);
        k = 0;
    }

    int next() {
        return nums[k++];
    }

    bool hasNext() {
        return k < nums.size();
    }
};

int main() {

    int nu = INT_MAX;
    vector<int> nums = {
            7,
            3, 15,
            nu, nu, 9, 20
    };
    TreeNode *root = MyTree(nums).getRoot();

    BSTIterator t = BSTIterator(root);
    cout << t.next() << endl;  // 3
    cout << t.next() << endl;  // 7
    cout << t.hasNext() << endl;  // true
    cout << t.next() << endl;  // 9
    cout << t.hasNext() << endl;  // true
    cout << t.next() << endl;  // 15
    cout << t.hasNext() << endl;  // true
    cout << t.next() << endl;  // 20
    cout << t.hasNext() << endl;  // false

    return 0;
}
