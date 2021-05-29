// Created by WXX on 2021/5/29 18:28
#include "MyLinkedList.h"

/**
 * 执行用时：28 ms, 在所有 C++ 提交中击败了65.11%的用户
 * 内存消耗：16.1 MB, 在所有 C++ 提交中击败了83.78%的用户
 */
// 蓄水池抽样
class Solution {
public:

    ListNode* h;
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    Solution(ListNode* head) {
        h = head;
    }

    /** Returns a random node's value. */
    int getRandom() {
        int c = -1, n = 0;
        for (auto p = h; p; p = p->next) {
            n++;
            if (rand() % n == 0) c = p->val;  // 此时有1/n概率抽到p->val
        }
        return c;
    }
};

int main() {

    ListNode *head = MyLinkedList({1, 2, 3}).getHead();
    cout << Solution(head).getRandom() << endl;
    cout << Solution(head).getRandom() << endl;
    cout << Solution(head).getRandom() << endl;

    return 0;
}
