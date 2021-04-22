// Created by WXX on 2021/4/22 18:50
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    vector<vector<int>> fourSum(vector<int> &nums, int target) {

        sort(nums.begin(), nums.end());

        vector<vector<int>> res;
        for (int i = 0; i < nums.size(); i++) {
            if (i && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.size(); j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                // 双指针算法
                for (int k = j + 1, u = nums.size() - 1; k < u; k++) {
                    if (k > j + 1 && nums[k] == nums[k - 1]) continue;
                    while (k < u - 1 && nums[i] + nums[j] + nums[k] + nums[u - 1] >= target) u--;
                    if (nums[i] + nums[j] + nums[k] + nums[u] == target) {
                        res.push_back({nums[i], nums[j], nums[k], nums[u]});
                    }
                }
            }
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

    vector<int> nums = {1, 0, -1, 0, -2, 2};
    OutputBasicArray2D1(Solution().fourSum(nums, 0));

    return 0;
}
