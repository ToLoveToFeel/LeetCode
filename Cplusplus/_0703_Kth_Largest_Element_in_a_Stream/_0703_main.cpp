// Created by WXX on 2021/2/11 19:18
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

/**
 * 执行用时：40 ms, 在所有 C++ 提交中击败了90.53%的用户
 * 内存消耗：19.4 MB, 在所有 C++ 提交中击败了77.93%的用户
 */
class KthLargest {
public:

    priority_queue<int, vector<int>, greater<int>> pq;  // 小顶堆
    int k;

    KthLargest(int _k, vector<int> &nums) {
        k = _k;
        for (int num : nums) {
            pq.push(num);
            if (pq.size() > k) pq.pop();
        }
    }

    int add(int val) {
        pq.push(val);
        if (pq.size() > k) pq.pop();
        return pq.top();
    }
};

int main() {

    vector<int> nums = {4, 5, 8, 2};
    KthLargest t = KthLargest(3, nums);
    cout << t.add(3) << endl;  // 4
    cout << t.add(5) << endl;  // 5
    cout << t.add(10) << endl;  // 5
    cout << t.add(9) << endl;  // 8
    cout << t.add(4) << endl;  // 8

    return 0;
}
