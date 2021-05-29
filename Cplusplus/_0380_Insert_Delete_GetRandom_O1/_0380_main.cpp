// Created by WXX on 2021/5/29 16:13
#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

/**
 * 执行用时：48 ms, 在所有 C++ 提交中击败了59.19%的用户
 * 内存消耗：22 MB, 在所有 C++ 提交中击败了77.50%的用户
 */
class RandomizedSet {
public:

    unordered_map<int, int> hash;  // (数据，数据在数组中的下标)
    vector<int> nums;

    /** Initialize your data structure here. */
    RandomizedSet() {

    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    bool insert(int x) {
        if (hash.count(x) == 0) {
            nums.push_back(x);
            hash[x] = nums.size() - 1;
            return true;
        }
        return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    bool remove(int x) {
        if (hash.count(x)) {
            int y = nums.back();
            int px = hash[x], py = hash[y];  // x, y在nums对应的下标为px, py
            swap(nums[px], nums[py]);
            swap(hash[x], hash[y]);
            nums.pop_back();
            hash.erase(x);
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    int getRandom() {
        return nums[rand() % nums.size()];
    }
};

int main() {

    auto* r = new RandomizedSet();
    cout << r->insert(1) << endl;  // true
    cout << r->remove(2) << endl;  // false
    cout << r->insert(2) << endl;  // true
    cout << r->getRandom() << endl;  // 2
    cout << r->remove(1) << endl;  // true
    cout << r->insert(2) << endl;  // false
    cout << r->getRandom() << endl;  // 2

    return 0;
}
