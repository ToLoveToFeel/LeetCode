// Created by WXX on 2021/4/22 20:29
#include "MyLinkedList.h"

// 递归
class Solution {
public:
    // 递归算法关键是抓住函数定义：返回l1和l2合并后的头结点
    ListNode *mergeTwoLists(ListNode *l1, ListNode *l2) {

        if (!l1) return l2;
        if (!l2) return l1;

        if (l1->val < l2->val) {
            l1->next = mergeTwoLists(l1->next, l2);
            return l1;
        } else {
            l2->next = mergeTwoLists(l1, l2->next);
            return l2;
        }
    }
};

int main() {

    ListNode *l1 = MyLinkedList({1, 2, 4}).getHead();
    ListNode *l2 = MyLinkedList({1, 3, 4}).getHead();
    MyLinkedList().printLinkedList(Solution().mergeTwoLists(l1, l2));

    return 0;
}
