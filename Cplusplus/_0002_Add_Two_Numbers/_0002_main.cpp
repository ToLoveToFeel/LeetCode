#include "MyLinkedList.h"

/**
 * 执行用时：40 ms, 在所有 C++ 提交中击败了88.85%的用户
 * 内存消耗：69.9 MB, 在所有 C++ 提交中击败了33.10%的用户
 */
class Solution {
public:
    ListNode *addTwoNumbers(ListNode *l1, ListNode *l2) {

        auto dummy = new ListNode(0), cur = dummy;

        int t = 0;
        while (l1 || l2 || t) {
            if (l1) t += l1->val, l1 = l1->next;
            if (l2) t += l2->val, l2 = l2->next;
            cur = (cur->next = new ListNode(t % 10));
            t /= 10;
        }
        return dummy->next;
    }
};

int main() {

    ListNode *l1 = MyLinkedList({2, 4, 3}).getHead();
    ListNode *l2 = MyLinkedList({5, 6, 4}).getHead();
    ListNode *l = Solution().addTwoNumbers(l1, l2);
    MyLinkedList().printLinkedList(l);

    return 0;
}