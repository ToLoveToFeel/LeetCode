// Created by WXX on 2021/7/19 21:12
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：24 ms, 在所有 C++ 提交中击败了44.15%的用户
 * 内存消耗：15.5 MB, 在所有 C++ 提交中击败了96.59%的用户
 */
class Solution {
public:
    vector<int> singleNumbers(vector<int> &nums) {
        int s = 0;
        for (auto x : nums) s ^= x;

        int t = (s & -s);
        int res = 0;
        for (int x : nums)
            if (x & t)
                res ^= x;
        return {res, res ^ s};
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

    vector<int> nums = {4, 1, 4, 6};
    OutputBasicArray1D(Solution().singleNumbers(nums));  // [1, 6]

    return 0;
}
