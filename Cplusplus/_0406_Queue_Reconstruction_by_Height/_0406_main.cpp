// Created by WXX on 2021/4/6 15:35
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

/**
 * 执行用时：200 ms, 在所有 C++ 提交中击败了35.38%的用户
 * 内存消耗：11.8 MB, 在所有 C++ 提交中击败了70.56%的用户
 */
class Solution {
public:
    vector<vector<int>> reconstructQueue(vector<vector<int>> &people) {

        // 按照第一维降序，第二维升序排列
        sort(people.begin(), people.end(), [](const vector<int> &a, const vector<int> &b) {
            if (a[0] == b[0]) return a[1] < b[1];
            return a[0] > b[0];
        });

        vector<vector<int>> res;
        for (auto &p : people) {
            res.insert(res.begin() + p[1], p);
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

    vector<vector<int>> people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
    OutputBasicArray2D1(Solution().reconstructQueue(people));

    return 0;
}
