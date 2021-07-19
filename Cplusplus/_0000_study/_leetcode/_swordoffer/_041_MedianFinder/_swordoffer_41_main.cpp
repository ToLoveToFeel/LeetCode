// Created by WXX on 2021/7/19 15:50
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

/**
 * 执行用时：100 ms, 在所有 C++ 提交中击败了94.28%的用户
 * 内存消耗：40.6 MB, 在所有 C++ 提交中击败了84.10%的用户
 */
class MedianFinder {
public:
    priority_queue<int> down;  // 大根堆
    priority_queue<int, vector<int>, greater<int>> up;  // 小根堆

    /** initialize your data structure here. */
    MedianFinder() {

    }

    void addNum(int x) {
        if (down.empty() || x <= down.top()) down.push(x);
        else up.push(x);

        if (up.size() > down.size()) down.push(up.top()), up.pop();
        if (down.size() > up.size() + 1) up.push(down.top()), down.pop();
    }

    double findMedian() {
        if ((down.size() + up.size()) % 2) return down.top();
        else return (down.top() + up.top()) / 2.0;
    }
};

int main() {

    MedianFinder t = MedianFinder();
    t.addNum(1);
    t.addNum(2);
    cout << t.findMedian() << endl;  // 1.5
    t.addNum(3);
    cout << t.findMedian() << endl;  // 2

    return 0;
}
