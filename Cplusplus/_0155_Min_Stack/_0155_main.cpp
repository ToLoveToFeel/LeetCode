// Created by WXX on 2021/1/22 16:30
#include <iostream>
#include <stack>

using namespace std;

/**
 * 执行用时：28 ms, 在所有 C++ 提交中击败了94.57%的用户
 * 内存消耗：15.6 MB, 在所有 C++ 提交中击败了5.00%的用户
 */
class MinStack {
public:
    /** initialize your data structure here. */
    stack<int> stk;  // 存储元素
    stack<int> f;  // 存储最小值，加上优化，如果x > f.top()不用在f中插入x

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

    int getMin() {
        return f.top();
    }
};

int main() {

    MinStack *stk = new MinStack();
    stk->push(-2);
    stk->push(0);
    stk->push(-3);
    cout << stk->getMin() << endl;  // -3
    stk->pop();
    cout << stk->top() << endl;  // 0
    cout << stk->getMin() << endl;  // -2

    return 0;
}