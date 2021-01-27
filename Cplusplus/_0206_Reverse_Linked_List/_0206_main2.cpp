// Created by WXX on 2021/1/27 14:46
#include "MyLinkedList.h"

/**
 * 执行用时：8 ms, 在所有 C++ 提交中击败了86.01%的用户
 * 内存消耗：8.3 MB, 在所有 C++ 提交中击败了84.53%的用户
 */
class Solution {
public:
    ListNode *reverseList(ListNode *head) {

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
