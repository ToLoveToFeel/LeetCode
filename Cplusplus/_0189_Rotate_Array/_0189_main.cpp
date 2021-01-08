#include <cstring>
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

/**
 * 执行用时：4 ms, 在所有 C++ 提交中击败了98.94%的用户
 * 内存消耗：9.8 MB, 在所有 C++ 提交中击败了89.24%的用户
 */
class Solution {
public:
    void rotate(vector<int> &nums, int k) {
        int n = nums.size();
        k %= n;
        reverse(nums.begin(), nums.end());
        reverse(nums.begin(), nums.begin() + k);
        reverse(nums.begin() + k, nums.end());
    }
};

void OutputBasicArray1D(vector<int> &nums) {
    cout << "[";
    for (int i = 0; i < nums.size(); i++) {
        cout << nums[i];
        if (i != nums.size() - 1) cout << ", ";
    }
    cout << "]" << endl;
}

int main() {

    vector<int> nums = {1, 2, 3, 4, 5, 6, 7};
    Solution().rotate(nums, 3);
    OutputBasicArray1D(nums);

    return 0;
}