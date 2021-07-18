// Created by WXX on 2021/7/18 17:20
#include "MyLinkedList.h"

class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        if (!l1) return l2;
        if (!l2) return l1;

        if (l1->val <= l2->val) {
            l1->next = mergeTwoLists(l1->next, l2);
            return l1;
        } else {
            l2->next = mergeTwoLists(l1, l2->next);
            return l2;
        }
    }
};

int main() {

    ListNode *l1 = MyLinkedList({1, 2, 4}).getHead();
    ListNode *l2 = MyLinkedList({1, 3, 4}).getHead();
    MyLinkedList().printLinkedList(Solution().mergeTwoLists(l1, l2));

    return 0;
}
