// Created by WXX on 2021/6/30 21:00
#include <iostream>
#include <stack>

using namespace std;

class CQueue {
public:

    stack<int> stk1, stk2;

    CQueue() {

    }

    void appendTail(int x) {
        stk1.push(x);
    }

    int deleteHead() {
        if (stk2.empty()) {
            while (stk1.size()) stk2.push(stk1.top()), stk1.pop();
        }
        if (stk2.size()) {
            int t = stk2.top();
            stk2.pop();
            return t;
        }
        return -1;
    }
};

int main() {

    CQueue* q = new CQueue();
    q->appendTail(3);
    cout << q->deleteHead() << endl;  // 3
    cout << q->deleteHead() << endl;  // -1

    return 0;
}
