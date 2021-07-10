// Created by WXX on 2021/7/10 16:16
#include <iostream>
#include <vector>
#include <unordered_map>
#include <algorithm>

using namespace std;

/**
 * 执行用时：276 ms, 在所有 C++ 提交中击败了97.99%的用户
 * 内存消耗：124.7 MB, 在所有 C++ 提交中击败了97.99%的用户
 */
class TimeMap {
public:
    unordered_map<string, vector<int>> hash_time;
    unordered_map<string, vector<string>> hash_value;

    /** Initialize your data structure here. */
    TimeMap() {

    }

    void set(string key, string value, int timestamp) {
        hash_time[key].push_back(timestamp);
        hash_value[key].push_back(value);
    }

    string get(string key, int timestamp) {
        if (!hash_time.count(key) || timestamp < *hash_time[key].begin()) return "";
        if (timestamp >= *hash_time[key].rbegin()) return *hash_value[key].rbegin();

        vector<int>::iterator it = upper_bound(hash_time[key].begin(), hash_time[key].end(), timestamp);
        return hash_value[key][it - hash_time[key].begin() - 1];
    }
};

int main() {

    TimeMap *t = new TimeMap();
    t->set("a", "bar", 1);
    t->set("x", "b", 3);
    cout << t->get("b", 3) << endl;
    t->set("foo", "bar2", 4);
    cout << t->get("foo", 4) << endl;
    cout << t->get("foo", 5) << endl;

    return 0;
}
