// Created by WXX on 2021/2/27 21:14
#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

// 使用堆实现，时间复杂度：O(n*log(k))
class Solution {
public:
    typedef pair<int, int> PII;

    vector<int> findClosestElements(vector<int> &arr, int k, int x) {

        priority_queue<PII> heap;
        for (auto v : arr) {
            heap.push({abs(x - v), v});
            if (heap.size() > k) heap.pop();
        }
        vector<int> res;
        while (heap.size()) res.push_back(heap.top().second), heap.pop();
        sort(res.begin(), res.end());
        return res;
    }
};

void OutputBasicArray1D(vector<int> nums) {
    cout << "[";
    for (int i = 0; i < nums.size(); i++) {
        cout << nums[i];
        if (i != nums.size() - 1) cout << ", ";
    }
    cout << "]" << endl;
}

int main() {

    vector<int> arr = {1, 2, 3, 4, 5};
    OutputBasicArray1D(Solution().findClosestElements(arr, 4, 3));  // [1, 2, 3, 4]

    return 0;
}
