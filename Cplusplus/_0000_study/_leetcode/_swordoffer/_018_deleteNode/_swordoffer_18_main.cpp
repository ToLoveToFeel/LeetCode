// Created by WXX on 2021/7/18 16:08
#include "MyLinkedList.h"

class Solution {
public:
    ListNode *deleteNode(ListNode *head, int val) {
        auto dummy = new ListNode(-1);
        dummy->next = head;
        for (auto p = dummy; p->next; p = p->next)
            if (p->next->val == val) {
                p->next = p->next->next;
                break;
            }
        return dummy->next;
    }
};

int main() {

    ListNode *head = MyLinkedList({4, 5, 1, 9}).getHead();
    MyLinkedList().printLinkedList(Solution().deleteNode(head, 5));

    return 0;
}
