// Created by WXX on 2021/3/14 10:04
#include <iostream>
#include <vector>

using namespace std;

const int N = 19997;
typedef pair<int, int> PII;

// 拉链法
/**
 * 执行用时：132 ms, 在所有 C++ 提交中击败了75.77%的用户
 * 内存消耗：68.8 MB, 在所有 C++ 提交中击败了32.77%的用户
 */
class MyHashMap {
public:
    vector<PII> h[N];

    /** Initialize your data structure here. */
    MyHashMap() {

    }

    // 如果存在该数据，返回所在bin中的位置下标，否则返回-1
    int find(vector<PII> &h, int key) {
        for (int i = 0; i < h.size(); i++)
            if (h[i].first == key)
                return i;
        return -1;
    }

    /** value will always be non-negative. */
    void put(int key, int value) {
        int t = key % N;  // 求hash值
        int k = find(h[t], key);
        if (k == -1) h[t].push_back({key, value});
        else h[t][k].second = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    int get(int key) {
        int t = key % N;  // 求hash值
        int k = find(h[t], key);
        if (k == -1) return -1;
        else return h[t][k].second;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    void remove(int key) {
        int t = key % N;  // 求hash值
        int k = find(h[t], key);
        if (k != -1) h[t].erase(h[t].begin() + k);
    }
};

int main() {

    MyHashMap t = MyHashMap();
    t.put(1, 1);
    t.put(2, 2);
    cout << t.get(1) << endl;  // 1
    cout << t.get(3) << endl;  // -1
    t.put(2, 12);
    cout << t.get(2) << endl;  // 12
    t.remove(2);
    cout << t.get(2) << endl;  // -1

    return 0;
}
