// Created by WXX on 2021/7/20 15:59
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

class MaxQueue {
public:
    queue<int> q;
    deque<int> f;  // 严格单调递减序列

    MaxQueue() {

    }

    int max_value() {
        if (f.empty()) return -1;
        return f.front();
    }

    void push_back(int x) {
        while (f.size() && f.back() < x) f.pop_back();
        q.push(x);
        f.push_back(x);
    }

    int pop_front() {
        if (q.empty()) return -1;
        int t = q.front();
        q.pop();
        if (t == f.front()) f.pop_front();
        return t;
    }
};

int main() {

    MaxQueue *t = new MaxQueue();
    t->push_back(1);
    t->push_back(2);
    cout << t->max_value() << endl;  // 2
    cout << t->pop_front() << endl;  // 1
    cout << t->max_value() << endl;  // 2

    return 0;
}
