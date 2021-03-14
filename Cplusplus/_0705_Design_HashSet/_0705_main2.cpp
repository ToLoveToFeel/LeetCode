// Created by WXX on 2021/3/14 20:36
#include <iostream>
#include <vector>

using namespace std;

const int N = 20003;

/**
 * 执行用时：104 ms, 在所有 C++ 提交中击败了70.08%的用户
 * 内存消耗：56.2 MB, 在所有 C++ 提交中击败了21.70%的用户
 */
class MyHashSet {
public:
    vector<int> h[N];

    /** Initialize your data structure here. */
    MyHashSet() {

    }

    // 如果存在该数据，返回所在bin中的位置下标，否则返回-1
    int find(vector<int> &h, int key) {
        for (int i = 0; i < h.size(); i++)
            if (h[i] == key)
                return i;
        return -1;
    }

    void add(int key) {
        int t = key % N;
        int k = find(h[t], key);
        if (k == -1) h[t].push_back(key);
        else h[t][k] = key;
    }

    void remove(int key) {
        int t = key % N;
        int k = find(h[t], key);
        if (k != -1) h[t].erase(h[t].begin() + k);
    }

    /** Returns true if this set contains the specified element */
    bool contains(int key) {
        int t = key % N;
        int k = find(h[t], key);
        return k != -1;
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
