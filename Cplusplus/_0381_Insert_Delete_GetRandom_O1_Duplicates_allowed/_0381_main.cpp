// Created by WXX on 2021/5/29 17:18
#include <iostream>
#include <vector>
#include <unordered_map>
#include <unordered_set>

using namespace std;

class RandomizedCollection {
public:

    unordered_map<int, unordered_set<int>> hash;
    vector<int> nums;

    /** Initialize your data structure here. */
    RandomizedCollection() {

    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    bool insert(int x) {
        bool res = hash[x].empty();
        nums.push_back(x);
        hash[x].insert(nums.size() - 1);
        return res;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    bool remove(int x) {
        if (hash[x].size()) {
            int y = nums.back();
            int px = *hash[x].begin(), py = nums.size() - 1;
            swap(nums[px], nums[py]);
            hash[x].erase(px), hash[x].insert(py);  // 必须插入py，因为可能px==py
            hash[y].erase(py), hash[y].insert(px);
            nums.pop_back();
            hash[x].erase(py);
            return true;
        }
        return false;
    }

    /** Get a random element from the collection. */
    int getRandom() {
        return nums[rand() % nums.size()];
    }
};

int main() {

    RandomizedCollection* t = new RandomizedCollection();
    cout << t->insert(1) << endl;  // true
    cout << t->insert(1) << endl;  // true
    cout << t->insert(2) << endl;  // false
    cout << t->getRandom() << endl;
    cout << t->remove(1) << endl;  // true
    cout << t->getRandom() << endl;  // 2

    return 0;
}
