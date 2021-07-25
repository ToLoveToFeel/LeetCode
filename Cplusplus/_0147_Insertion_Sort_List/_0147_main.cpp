// Created by WXX on 2021/7/25 18:22
#include "MyLinkedList.h"

using namespace std;

/**
 * 执行用时：36 ms, 在所有 C++ 提交中击败了42.17%的用户
 * 内存消耗：9.4 MB, 在所有 C++ 提交中击败了21.86%的用户
 */
class Solution {
public:
    ListNode* insertionSortList(ListNode* head) {
        auto dummy = new ListNode(-1);
        for (auto p = head; p; ) {
            auto cur = dummy, next = p->next;  // next是下一个需要考察的节点
            while (cur->next && cur->next->val < p->val) cur = cur->next;
            p->next = cur->next;
            cur->next = p;
            p = next;
        }
        return dummy->next;
    }
};

int main() {

    ListNode *head = MyLinkedList({1, 2, 3, 4}).getHead();
    MyLinkedList().printLinkedList(Solution().insertionSortList(head));

    return 0;
}
