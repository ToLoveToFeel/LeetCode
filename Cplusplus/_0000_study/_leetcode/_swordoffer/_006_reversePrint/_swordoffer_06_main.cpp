// Created by WXX on 2021/7/18 14:33
#include "MyLinkedList.h"

class Solution {
public:
    vector<int> reversePrint(ListNode *head) {
        vector<int> res;
        for (auto p = head; p; p = p->next) res.push_back(p->val);
        reverse(res.begin(), res.end());
        return res;
    }
};

int main() {

    ListNode *head = MyLinkedList({1, 3, 2}).getHead();
    OutputBasicArray1D(Solution().reversePrint(head));  // [2, 3, 1]

    return 0;
}
