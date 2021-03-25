// Created by WXX on 2021/3/25 8:56
#include "MyLinkedList.h"

using namespace std;

/**
 * 执行用时：12 ms, 在所有 C++ 提交中击败了44.50%的用户
 * 内存消耗：10.9 MB, 在所有 C++ 提交中击败了29.00%的用户
 */
class Solution {
public:
    ListNode *deleteDuplicates(ListNode *head) {

        if (!head || !head->next) return head;

        auto dummy = new ListNode(-1);
        dummy->next = head;

        auto a = dummy, b = a->next, c = b->next;
        while (c) {
            while (c && b->val == c->val) c = c->next;
            if (b->next != c) a->next = c;  // 说明含有重复元素
            else a = b;

            b = c;
            if (c) c = c->next;
        }
        return dummy->next;
    }
};

int main() {

    ListNode *head = MyLinkedList({1, 2, 3, 3, 4, 4, 5}).getHead();
    MyLinkedList().printLinkedList(Solution().deleteDuplicates(head));

    return 0;
}
