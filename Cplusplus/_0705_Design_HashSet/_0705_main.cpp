// Created by WXX on 2021/3/13 9:07
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：160 ms, 在所有 C++ 提交中击败了43.51%的用户
 * 内存消耗：175.6 MB, 在所有 C++ 提交中击败了5.11%的用户
 */
class MyHashSet {
public:
    const int N = 1e6 + 10;
    vector<int> res;

    /** Initialize your data structure here. */
    MyHashSet() {
        res.resize(N);
    }

    void add(int key) {
        res[key] = 1;
    }

    void remove(int key) {
        res[key] = 0;
    }

    /** Returns true if this set contains the specified element */
    bool contains(int key) {
        return res[key];
    }
};

int main() {

    MyHashSet t = MyHashSet();
    t.add(1);
    t.add(2);
    cout << t.contains(1) << endl;  // true
    cout << t.contains(3) << endl;  // false
    t.remove(2);
    cout << t.contains(2) << endl;  // false

    return 0;
}
