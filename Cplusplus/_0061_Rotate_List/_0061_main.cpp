// Created by WXX on 2021/3/27 11:07
#include "MyLinkedList.h"

class Solution {
public:
    ListNode *rotateRight(ListNode *head, int k) {
        if (k == 0 || !head) return head;

        int cnt = 0;
        auto p = head;
        while (p) {
            cnt++;
            p = p->next;
        }
        k %= cnt;
        if (!k) return head;

        auto a = head, b = head;
        for (int i = 0; i < k; i++) b = b->next;
        while (b->next) {
            a = a->next;
            b = b->next;
        }
        auto res = a->next;
        a->next = NULL;
        b->next = head;

        return res;
    }
};

int main() {

    ListNode *head = MyLinkedList({1, 2, 3, 4, 5}).getHead();
    MyLinkedList().printLinkedList(Solution().rotateRight(head, 2));

    return 0;
}
