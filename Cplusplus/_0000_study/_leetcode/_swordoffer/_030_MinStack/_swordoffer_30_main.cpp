// Created by WXX on 2021/7/19 11:25
#include <iostream>
#include <stack>

using namespace std;

class MinStack {
public:
    stack<int> stk;
    stack<int> f;

    /** initialize your data structure here. */
    MinStack() {

    }

    void push(int x) {
        stk.push(x);
        if (f.empty() || f.top() >= x) f.push(x);
    }

    void pop() {
        if (stk.top() <= f.top()) f.pop();
        stk.pop();
    }

    int top() {
        return stk.top();
    }

    int min() {
        return f.top();
    }
};

int main() {

    MinStack *stk = new MinStack();
    stk->push(-2);
    stk->push(0);
    stk->push(-3);
    cout << stk->min() << endl;  // -3
    stk->pop();
    cout << stk->top() << endl;  // 0
    cout << stk->min() << endl;  // -2

    return 0;
}
