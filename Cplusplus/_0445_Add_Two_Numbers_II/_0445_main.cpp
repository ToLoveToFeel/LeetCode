// Created by WXX on 2021/6/3 15:29
#include "MyLinkedList.h"

/**
 * 执行用时：44 ms, 在所有 C++ 提交中击败了58.69%的用户
 * 内存消耗：69.3 MB, 在所有 C++ 提交中击败了83.54%的用户
 */
class Solution {
public:
    ListNode *addTwoNumbers(ListNode *l1, ListNode *l2) {
        // 第一步：将两个链表翻转 Leetcode 0206
        l1 = reverseList(l1), l2 = reverseList(l2);
        // 第二步：相加 Leetcode 0002
        ListNode *l = addTwoReverseOrderNumbers(l1, l2);
        // 第三步：将结果翻转并返回
        return reverseList(l);
    }

    ListNode *reverseList(ListNode *head) {
        if (!head) return head;
        auto a = head, b = a->next;
        while (b) {
            auto c = b->next;
            b->next = a;
            a = b, b = c;
        }
        head->next = NULL;
        return a;
    }

    ListNode *addTwoReverseOrderNumbers(ListNode *l1, ListNode *l2) {

        ListNode *dummy = new ListNode(0), *cur = dummy;
        int t = 0;
        while (l1 || l2 || t) {
            if (l1) t += l1->val, l1 = l1->next;
            if (l2) t += l2->val, l2 = l2->next;
            cur->next = new ListNode(t % 10);
            t /= 10;
            cur = cur->next;
        }
        return dummy->next;
    }
};

int main() {

    ListNode *l1 = MyLinkedList({7, 2, 4, 3}).getHead();
    ListNode *l2 = MyLinkedList({5, 6, 4}).getHead();
    MyLinkedList().printLinkedList(Solution().addTwoNumbers(l1, l2));  // 7->8->0->7->NULL

    return 0;
}
