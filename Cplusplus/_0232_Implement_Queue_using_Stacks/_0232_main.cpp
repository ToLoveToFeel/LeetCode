// Created by WXX on 2021/3/5 10:04
#include <iostream>
#include <stack>

using namespace std;

/**
 * 执行用时：4 ms, 在所有 C++ 提交中击败了32.31%的用户
 * 内存消耗：6.7 MB, 在所有 C++ 提交中击败了82.09%的用户
 */
class MyQueue {
public:
    stack<int> stk1, stk2;
    int front;

    /** Initialize your data structure here. */
    MyQueue() {

    }

    /** Push element x to the back of queue. */
    void push(int x) {
        if (stk1.empty()) front = x;
        stk1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    int pop() {
        if (stk2.empty()) {
            while (stk1.size()) stk2.push(stk1.top()), stk1.pop();
        }
        int t = stk2.top();
        stk2.pop();
        return t;
    }

    /** Get the front element. */
    int peek() {
        if (stk2.size()) return stk2.top();
        return front;
    }

    /** Returns whether the queue is empty. */
    bool empty() {
        return stk1.empty() && stk2.empty();
    }
};

int main() {

    MyQueue t = MyQueue();
    t.push(1);
    t.push(2);
    cout << t.peek() << endl;  // 1
    cout << t.pop() << endl;  // 1
    cout << t.empty() << endl;  // 0

    return 0;
}
