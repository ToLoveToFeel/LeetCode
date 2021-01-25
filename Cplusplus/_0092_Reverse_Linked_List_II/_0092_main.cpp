// Created by WXX on 2021/1/25 14:07
#include "MyLinkedList.h"

/**
 * 执行用时：4 ms, 在所有 C++ 提交中击败了52.53%的用户
 * 内存消耗：7.2 MB, 在所有 C++ 提交中击败了5.01%的用户
 */
class Solution {
public:
    ListNode *reverseBetween(ListNode *head, int m, int n) {

        auto dummy = new ListNode(-1);
        dummy->next = head;

        auto a = dummy;
        for (int i = 0; i < m - 1; i++) a = a->next;
        auto b = a->next, c = b->next;
        for (int i = 0; i < n - m; i++) {
            auto t = c->next;
            c->next = b;
            b = c, c = t;
        }
        a->next->next = c;
        a->next = b;
        return dummy->next;
    }
};

int main() {

    ListNode *head = MyLinkedList({1, 2, 3, 4, 5}).getHead();
    Solution().reverseBetween(head, 2, 4);
    MyLinkedList().printLinkedList(head);

    return 0;
}
