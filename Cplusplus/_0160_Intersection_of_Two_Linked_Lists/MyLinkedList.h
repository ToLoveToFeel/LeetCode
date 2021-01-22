#ifndef CPLUSPLUS_MYLINKEDLIST_H
#define CPLUSPLUS_MYLINKEDLIST_H

#include <cstring>
#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

struct ListNode {
    int val;
    ListNode *next;

    ListNode(int x) : val(x), next(NULL) {}
};

class MyLinkedList {

private:
    ListNode *head;

public:
    MyLinkedList() {
        head = NULL;
    }

    // ListNode *l1 = MyLinkedList({2, 4, 3}).getHead();
    MyLinkedList(vector<int> nums) {
        head = createLinkedList(nums);
    }

    ListNode *getHead() {
        return head;
    }

    // 创建链表
    ListNode *createLinkedList(vector<int> nums) {
        if (nums.size() == 0)
            return NULL;

        auto *newHead = new ListNode(nums[0]);

        ListNode *curNode = newHead;
        for (int i = 1; i < nums.size(); i++) {
            curNode->next = new ListNode(nums[i]);
            curNode = curNode->next;
        }

        return newHead;
    }

    void printLinkedList() {
        printLinkedList(head);
    }

    // 打印链表
    static void printLinkedList(ListNode *head) {
        ListNode *curNode = head;
        while (curNode) {
            cout << curNode->val << "->";
            curNode = curNode->next;
        }
        cout << "NULL" << endl;
    }

};


#endif //CPLUSPLUS_MYLINKEDLIST_H
