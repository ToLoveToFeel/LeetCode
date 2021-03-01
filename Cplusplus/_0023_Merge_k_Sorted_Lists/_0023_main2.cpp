// Created by WXX on 2021/3/1 18:55
#include "MyLinkedList.h"
#include <queue>

/**
 * 执行用时：28 ms, 在所有 C++ 提交中击败了84.47%的用户
 * 内存消耗：13 MB, 在所有 C++ 提交中击败了74.60%的用户
 */
class Solution {
public:

    struct Cmp {
        // STL容器在比较的时候用的是结构体的小括号运算符
        bool operator() (ListNode *a, ListNode *b) {
            return a->val > b->val;
        }
    };

    ListNode *mergeKLists(vector<ListNode *> &lists) {

        priority_queue<ListNode*, vector<ListNode*>, Cmp> heap;
        auto dummy = new ListNode(-1), tail = dummy;
        for (auto l : lists) if (l) heap.push(l);

        while (heap.size()) {
            auto t = heap.top();
            heap.pop();

            tail = tail->next = t;
            if (t->next) heap.push(t->next);
        }
        return dummy->next;
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
