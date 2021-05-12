// Created by WXX on 2021/5/12 21:45
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

typedef vector<int> VI;  // (a[i] + b[j], i, j)

/**
 * 执行用时：20 ms, 在所有 C++ 提交中击败了69.17%的用户
 * 内存消耗：9.5 MB, 在所有 C++ 提交中击败了54.03%的用户
 */
class Solution {
public:
    vector<vector<int>> kSmallestPairs(vector<int> &a, vector<int> &b, int k) {

        if (a.empty() || b.empty()) return {};

        int n = a.size(), m = b.size();
        priority_queue<VI, vector<VI>, greater<VI>> heap;
        for (int i = 0; i < m; i++) heap.push({a[0] + b[i], 0, i});
        vector<VI> res;
        while (k-- && heap.size()) {
            auto t = heap.top(); heap.pop();
            res.push_back({a[t[1]], b[t[2]]});
            if (t[1] + 1 < n)
                heap.push({a[t[1] + 1] + b[t[2]], t[1] + 1, t[2]});
        }
        return res;
    }
};

void OutputBasicArray2D1(vector<vector<int>> nums) {

    cout << "[";
    for (int i = 0; i < nums.size(); i++) {
        cout << "[";
        for (int j = 0; j < nums[i].size(); j++) {
            cout << nums[i][j];
            if (j != nums[i].size() - 1) cout << ", ";
        }
        cout << "]";
        if (i != nums.size() - 1) cout << ", ";
    }
    cout << "]" << endl;
}

int main() {

    vector<int> a = {1, 7, 11}, b = {2, 4, 6};
    OutputBasicArray2D1(Solution().kSmallestPairs(a, b, 3));  // [[1, 2], [1, 4], [1, 6]]

    return 0;
}
