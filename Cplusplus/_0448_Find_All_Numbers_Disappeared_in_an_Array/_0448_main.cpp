// Created by WXX on 2021/2/13 8:51
#include <iostream>
#include <vector>

using namespace std;

// 思路：如果x在数组中出现，将nums[x - 1]标为负数
/**
 * 执行用时：64 ms, 在所有 C++ 提交中击败了81.79%的用户
 * 内存消耗：31.4 MB, 在所有 C++ 提交中击败了80.61%的用户
 */
class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int> &nums) {

        for (auto x : nums) {
            x = abs(x);
            if (nums[x - 1] > 0) nums[x - 1] *= -1;
        }
        vector<int> res;
        for (int i = 1; i <= nums.size(); i++)
            if (nums[i - 1] > 0)
                res.push_back(i);
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
    OutputBasicArray1D(Solution().findDisappearedNumbers(nums));

    return 0;
}
