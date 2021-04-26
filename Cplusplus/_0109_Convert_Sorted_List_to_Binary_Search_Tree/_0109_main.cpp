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

        auto s = head, f = head;  // 快慢指针
        ListNode *pre = NULL;  // s的上一个节点
        while (f && f->next) {
            pre = s;
            s = s->next;
            f = f->next->next;
        }

        auto root = new TreeNode(s->val);
        if (pre) {
            pre->next = NULL;
            root->left = sortedListToBST(head);
        }
        root->right = sortedListToBST(s->next);
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
    OutputBasicArray2D1(res);  // [[0],  [-3, 9],  [-10, 5]]

    return 0;
}