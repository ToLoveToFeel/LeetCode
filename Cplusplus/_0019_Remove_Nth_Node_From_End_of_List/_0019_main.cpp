// Created by WXX on 2021/4/22 19:32
#include "MyLinkedList.h"

class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {

        auto dummy = new ListNode(-1);
        dummy->next = head;
        auto p = dummy, q = dummy;

        for (int i = 0; i < n + 1; i++) q = q->next;
        while (q) p = p->next, q = q->next;

        p->next = p->next->next;

        return dummy->next;
    }
};

int main() {

    ListNode *head = MyLinkedList({1, 2, 3, 4, 5}).getHead();
    MyLinkedList().printLinkedList(Solution().removeNthFromEnd(head, 2));

    return 0;
}
