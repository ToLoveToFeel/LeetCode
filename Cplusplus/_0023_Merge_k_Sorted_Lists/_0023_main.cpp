// Created by WXX on 2021/3/1 17:13
#include "MyLinkedList.h"

/**
 * 执行用时：24 ms, 在所有 C++ 提交中击败了93.76%的用户
 * 内存消耗：13.1 MB, 在所有 C++ 提交中击败了70.38%的用户
 */
class Solution {
public:
    ListNode *merge(ListNode *l1, ListNode *l2) {
        if (l1 == NULL) return l2;
        if (l2 == NULL) return l1;

        if (l1->val < l2->val) {
            l1->next = merge(l1->next, l2);
            return l1;
        } else {
            l2->next = merge(l1, l2->next);
            return l2;
        }
    }

    ListNode *mergeKLists(vector<ListNode *> &lists) {

        if (lists.empty()) return NULL;
        for (int step = 1; step < lists.size(); step += step)  // 每次合并的两个链表的索引差值
            for (int i = 0; i + step < lists.size(); i += step + step)  // i 代表两个待合并链表中的第一个
                lists[i] = merge(lists[i], lists[i + step]);
        return lists[0];
    }
};

int main() {

    ListNode *l1 = MyLinkedList({1, 4, 5}).getHead();
    ListNode *l2 = MyLinkedList({1, 3, 4}).getHead();
    ListNode *l3 = MyLinkedList({2, 6}).getHead();
    vector<ListNode *> lists = {l1, l2, l3};
    ListNode *l = Solution().mergeKLists(lists);
    MyLinkedList().printLinkedList(l);

    return 0;
}
