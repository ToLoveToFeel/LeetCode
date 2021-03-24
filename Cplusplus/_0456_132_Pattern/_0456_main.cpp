// Created by ToLoveToFeel on 2021/3/24.
#include <iostream>
#include <vector>
#include <stack>

using namespace std;

// 单调递减栈：从后向前遍历所有元素，使用right记录小于当前考察值的最大值
/**
 * 执行用时：12 ms, 在所有 C++ 提交中击败了89.69%的用户
 * 内存消耗：13.4 MB, 在所有 C++ 提交中击败了63.56%的用户
 */
class Solution {
public:
    bool find132pattern(vector<int> &nums) {
        stack<int> stk;
        int right = INT_MIN;
        for (int i = nums.size() - 1; i >= 0; i--) {
            if (nums[i] < right) return true;
            while (stk.size() && nums[i] > stk.top()) {
                right = max(right, stk.top());
                stk.pop();
            }
            stk.push(nums[i]);
        }
        return false;
    }
};

int main() {

    vector<int> nums = {1, 2, 3, 4};
    cout << Solution().find132pattern(nums) << endl;  // false

    return 0;
}
