// Created by WXX on 2021/3/7 10:36
#include <iostream>
#include <vector>
#include <stack>

using namespace std;

/**
 * 执行用时：40 ms, 在所有 C++ 提交中击败了78.46%的用户
 * 内存消耗：23.5 MB, 在所有 C++ 提交中击败了17.00%的用户
 */
class Solution {
public:
    vector<int> nextGreaterElements(vector<int> &nums) {

        int n = nums.size();
        nums.insert(nums.end(), nums.begin(), nums.end());
        stack<int> stk;
        vector<int> res(n);
        for (int i = n * 2 - 1; i >= 0; i--) {
            int x = nums[i];
            while (stk.size() && x >= stk.top()) stk.pop();
            if (i < n) {
                if (stk.empty()) res[i] = -1;
                else res[i] = stk.top();
            }
            stk.push(x);
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

    vector<int> nums = {1, 2, 1};
    OutputBasicArray1D(Solution().nextGreaterElements(nums));

    return 0;
}
