// Created by WXX on 2021/3/26 8:52
#include "MyLinkedList.h"

class Solution {
public:
    ListNode *deleteDuplicates(ListNode *head) {

        if (!head || !head->next) return head;
        auto a = head, b = a->next;
        while (b) {
            if (a->val == b->val) a->next = b->next;
            else a = b;
            b = b->next;
        }
        return head;
    }
};

int main() {

    ListNode *head = MyLinkedList({1, 1, 3, 3, 4, 4, 5}).getHead();
    MyLinkedList().printLinkedList(Solution().deleteDuplicates(head));

    return 0;
}
