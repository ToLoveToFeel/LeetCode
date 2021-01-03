#include "MyLinkedList.h"

/**
 * 执行用时：40 ms, 在所有 C++ 提交中击败了88.85%的用户
 * 内存消耗：69.9 MB, 在所有 C++ 提交中击败了33.10%的用户
 */
class Solution {
public:
    ListNode *addTwoNumbers(ListNode *l1, ListNode *l2) {

        ListNode *dummyHead = new ListNode(0);
        ListNode *p = dummyHead;

        int t = 0;
        while (l1 || l2) {
            int num1 = (l1 ? l1->val : 0);
            int num2 = (l2 ? l2->val : 0);
            p->next = new ListNode((num1 + num2 + t) % 10);
            t = (num1 + num2 + t) / 10;
            l1 = (l1 ? l1->next : NULL);
            l2 = (l2 ? l2->next : NULL);
            p = p->next;
        }
        if (t != 0) p->next = new ListNode(t);

        return dummyHead->next;
    }
};

int main() {

    ListNode *l1 = MyLinkedList({2, 4, 3}).getHead();
    ListNode *l2 = MyLinkedList({5, 6, 4}).getHead();
    ListNode *l = Solution().addTwoNumbers(l1, l2);
    MyLinkedList().printLinkedList(l);

    return 0;
}