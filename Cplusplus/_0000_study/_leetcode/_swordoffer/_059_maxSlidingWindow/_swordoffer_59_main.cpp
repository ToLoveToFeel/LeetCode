// Created by WXX on 2021/7/19 22:13
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：16 ms, 在所有 C++ 提交中击败了94.78%的用户
 * 内存消耗：15.4 MB, 在所有 C++ 提交中击败了76.70%的用户
 */
class Solution {
public:
    vector<int> maxSlidingWindow(vector<int> &nums, int k) {
        int n = nums.size();
        if (!n) return {};
        int q[n];
        int hh = 0, tt = -1;
        vector<int> res;
        for (int i = 0; i < n; i++) {
            if (hh <= tt && i - q[hh] + 1 > k) hh++;
            while (hh <= tt && nums[i] >= nums[q[tt]]) tt--;
            q[++tt] = i;
            if (i >= k - 1) res.push_back(nums[q[hh]]);
        }
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

    vector<int> nums = {1, 3, -1, -3, 5, 3, 6, 7};
    OutputBasicArray1D(Solution().maxSlidingWindow(nums, 3));

    return 0;
}
