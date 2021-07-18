// Created by WXX on 2021/7/18 17:07
#include "MyLinkedList.h"

class Solution {
public:
    ListNode* getKthFromEnd(ListNode* head, int k) {
        auto q = head;
        for (int i = 0; i < k; i++) q = q->next;
        auto p = head;
        while (q) p = p->next, q = q->next;
        return p;
    }
};

int main() {

    ListNode *head = MyLinkedList({1, 2, 3, 4, 5}).getHead();
    MyLinkedList().printLinkedList(Solution().getKthFromEnd(head, 2));  // 4->5->NULL

    return 0;
}
