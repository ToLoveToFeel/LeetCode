// Created by WXX on 2021/1/30 20:43
#include <iostream>
#include <queue>

using namespace std;

// 考察数据结构：对顶堆
// 两个堆：一个大顶堆down，一个小顶堆up。如果一共奇数个元素，则规定down中多一个
/**
 * 执行用时：132 ms, 在所有 C++ 提交中击败了83.64%的用户
 * 内存消耗：45.7 MB, 在所有 C++ 提交中击败了28.87%的用户
 */
class MedianFinder {
public:
    priority_queue<int, vector<int>, greater<int>> up;  // 小顶堆
    priority_queue<int> down;  // 大顶堆

    /** initialize your data structure here. */
    MedianFinder() {

    }

    void addNum(int num) {
        if (down.empty() || num <= down.top()) {
            down.push(num);
            if (down.size() > up.size() + 1) {
                up.push(down.top());
                down.pop();
            }
        } else {
            up.push(num);
            if (up.size() > down.size()) {
                down.push(up.top());
                up.pop();
            }
        }
    }

    double findMedian() {
        if ((up.size() + down.size()) % 2) return down.top();
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
