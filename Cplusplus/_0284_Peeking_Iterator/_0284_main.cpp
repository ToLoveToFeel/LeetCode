// Created by WXX on 2021/1/30 17:40
#include <iostream>
#include <vector>

using namespace std;

class Iterator {
public:
    struct Data;
    Data *data;

    Iterator(const vector<int> &nums);

    Iterator(const Iterator &iter);

    // Returns the next element in the iteration.
    int next();

    // Returns true if the iteration has more elements.
    bool hasNext() const;
};

/**
 * 执行用时：4 ms, 在所有 C++ 提交中击败了81.99%的用户
 * 内存消耗：7.3 MB, 在所有 C++ 提交中击败了91.54%的用户
 */
class PeekingIterator : public Iterator {
public:
    int cur;
    bool has_next;

    PeekingIterator(const vector<int> &nums) : Iterator(nums) {
        // Initialize any member here.
        // **DO NOT** save a copy of nums and manipulate it directly.
        // You should only use the Iterator interface methods.
        has_next = Iterator::hasNext();
        if (has_next) cur = Iterator::next();
    }

    // Returns the next element in the iteration without advancing the iterator.
    int peek() {
        return cur;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    int next() {
        int t = cur;
        has_next = Iterator::hasNext();
        if (has_next) cur = Iterator::next();
        return t;
    }

    bool hasNext() const {
        return has_next;
    }
};

int main() {


    return 0;
}
