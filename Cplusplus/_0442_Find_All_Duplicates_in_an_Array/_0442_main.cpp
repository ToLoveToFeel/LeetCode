// Created by WXX on 2021/6/2 20:33
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：56 ms, 在所有 C++ 提交中击败了77.96%的用户
 * 内存消耗：32.7 MB, 在所有 C++ 提交中击败了50.00%的用户
 */
class Solution {
public:
    vector<int> findDuplicates(vector<int> &nums) {
        vector<int> res;
        for (auto x : nums) {
            int p = abs(x) - 1;
            nums[p] *= -1;
            if (nums[p] > 0) res.push_back(abs(x));
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

    vector<int> nums = {4, 3, 2, 7, 8, 2, 3, 1};
    OutputBasicArray1D(Solution().findDuplicates(nums));  // [2, 3]

    return 0;
}
