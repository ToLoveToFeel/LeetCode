// Created by WXX on 2021/7/19 21:27
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：168 ms, 在所有 C++ 提交中击败了95.57%的用户
 * 内存消耗：98.3 MB, 在所有 C++ 提交中击败了43.07%的用户
 */
class Solution {
public:
    vector<int> twoSum(vector<int> &nums, int target) {
        int i = 0, j = nums.size() - 1;  // 对撞指针
        while (i < j) {
            if (nums[i] + nums[j] == target) return {nums[i], nums[j]};
            if (nums[i] + nums[j] < target) i++;
            else j--;
        }
        return {};
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

    vector<int> nums = {2, 7, 11, 15};
    OutputBasicArray1D(Solution().twoSum(nums, 9));  // [2, 7]

    return 0;
}
