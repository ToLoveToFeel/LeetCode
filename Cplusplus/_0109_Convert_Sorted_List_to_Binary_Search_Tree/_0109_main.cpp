#include "MyTree.h"
#include "MyLinkedList.h"

/**
 * 执行用时：40 ms, 在所有 C++ 提交中击败了88.93%的用户
 * 内存消耗：30.2 MB, 在所有 C++ 提交中击败了98.85%的用户
 */
class Solution {
public:
    TreeNode *sortedListToBST(ListNode *head) {

        if (!head) return NULL;
        int n = 0;
        for (auto p = head; p; p = p->next) n++;
        if (n == 1) return new TreeNode(head->val);

        auto cur = head;
        // b/a上取整 = (b+a-1)/a下取整 ==> (n-1)/2上取整 = n/2下取整
        for (int i = 0; i < n / 2 - 1; i++) cur = cur->next;
        auto root = new TreeNode(cur->next->val);
        root->right = sortedListToBST(cur->next->next);
        cur->next = NULL;
        root->left = sortedListToBST(head);
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

    vector<int> l = {-10, -3, 0, 5, 9};
    ListNode *head = MyLinkedList(l).getHead();
    TreeNode *root = Solution().sortedListToBST(head);
    vector<vector<int>> res = MyTree().levelOrder(root);
    OutputBasicArray2D1(res);

    return 0;
}