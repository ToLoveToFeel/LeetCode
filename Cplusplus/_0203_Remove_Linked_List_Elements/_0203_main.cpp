// Created by WXX on 2021/1/26 19:32
#include "MyLinkedList.h"

/**
 * 执行用时：32 ms, 在所有 C++ 提交中击败了90.97%的用户
 * 内存消耗：14.9 MB, 在所有 C++ 提交中击败了86.24%的用户
 */
class Solution {
public:
    ListNode *removeElements(ListNode *head, int val) {

        if (head == NULL) return head;
        head->next = removeElements(head->next, val);
        return head->val == val ? head->next : head;
    }
};

int main() {

    ListNode *head = MyLinkedList({6, 2, 6, 3, 4, 5, 6}).getHead();
    head = Solution().removeElements(head, 6);
    MyLinkedList().printLinkedList(head);

    return 0;
}
