// Created by WXX on 2021/7/18 17:14
#include "MyLinkedList.h"

class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        if (!head || !head->next) return head;
        auto rhead = reverseList(head->next);
        head->next->next = head;
        head->next = NULL;
        return rhead;
    }
};

int main() {

    ListNode *head = MyLinkedList({1, 2, 3, 4, 5}).getHead();
    head = Solution().reverseList(head);
    MyLinkedList().printLinkedList(head);

    return 0;
}
