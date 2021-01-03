#include "MyLinkedList.h"

/**
 * 执行用时：4 ms, 在所有 C++ 提交中击败了96.98%的用户
 * 内存消耗：7.1 MB, 在所有 C++ 提交中击败了53.44%的用户
 */
class Solution {
public:
    ListNode *partition(ListNode *head, int x) {

        if (head == NULL || head->next == NULL) return head;

        ListNode *dummyHead1 = new ListNode(0);  // 记录 小于 x 的节点
        ListNode *dummyHead2 = new ListNode(0);  // 记录 大于或等于 x 的节点

        ListNode *node1 = dummyHead1;
        ListNode *node2 = dummyHead2;
        while (head != NULL) {
            if (head->val < x) {
                node1->next = head;
                node1 = node1->next;
            } else {
                node2->next = head;
                node2 = node2->next;
            }
            head = head->next;
        }
        node2->next = NULL;
        node1->next = dummyHead2->next;

        return dummyHead1->next;
    }
};

int main() {

    vector<int> nums = {1, 4, 3, 2, 5, 2};
    ListNode *head = MyLinkedList(nums).getHead();
    head = Solution().partition(head, 3);
    MyLinkedList().printLinkedList(head);

    return 0;
}