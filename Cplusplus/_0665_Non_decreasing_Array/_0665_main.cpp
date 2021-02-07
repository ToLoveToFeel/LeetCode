// Created by WXX on 2021/2/7 9:26
#include <iostream>
#include <vector>

using namespace std;

// nums[i] < nums[i - 1]，我们可以通过增大nums[i]或者减小nums[i - 1]使达到要求
// 如果nums[i - 2] > nums[i]，我们无法通过减小nums[i - 1]使达到要求
// 如果nums[i - 1] > nums[i + 1]，我们无法通过增大nums[i]使达到要求
/**
 * 执行用时：32 ms, 在所有 C++ 提交中击败了89.47%的用户
 * 内存消耗：26.2 MB, 在所有 C++ 提交中击败了96.18%的用户
 */
class Solution {
public:
    bool checkPossibility(vector<int> &nums) {

        int n = nums.size();
        bool flag = true;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                if (!flag) return false;
                if (i > 1 && i < n - 1 && nums[i - 2] > nums[i] && nums[i - 1] > nums[i + 1])
                    return false;
                flag = false;
            }
        }
        return true;
    }
};

int main() {

    vector<int> nums = {4, 2, 3};
    cout << Solution().checkPossibility(nums) << endl;  // true

    return 0;
}
