// Created by WXX on 2021/1/27 14:42
#include "MyLinkedList.h"

/**
 * 执行用时：4 ms, 在所有 C++ 提交中击败了99.14%的用户
 * 内存消耗：8.1 MB, 在所有 C++ 提交中击败了93.46%的用户
 */
class Solution {
public:
    ListNode *reverseList(ListNode *head) {

        if (!head) return NULL;
        auto a = head, b = a->next;
        while (b) {
            auto t = b->next;
            b->next = a;
            a = b, b = t;
        }
        head->next = NULL;
        return a;
    }
};

int main() {

    ListNode *head = MyLinkedList({1, 2, 3, 4, 5}).getHead();
    head = Solution().reverseList(head);
    MyLinkedList().printLinkedList(head);

    return 0;
}
