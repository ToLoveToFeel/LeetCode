// Created by WXX on 2021/7/17 16:09
#include <iostream>
#include <vector>
#include <stack>

using namespace std;

/**
 * 执行用时：148 ms, 在所有 C++ 提交中击败了42.85%的用户
 * 内存消耗：86.7 MB, 在所有 C++ 提交中击败了30.77%的用户
 */
class Solution {
public:
    vector<int> dailyTemperatures(vector<int> &t) {
        int n = t.size();
        stack<int> stk;
        vector<int> res(n, 0);
        for (int i = 0; i < n; i++) {
            while (stk.size() && t[stk.top()] < t[i]) {
                res[stk.top()] = i - stk.top();
                stk.pop();
            }
            if (stk.empty() || t[stk.top()] >= t[i]) stk.push(i);
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

    vector<int> t = {73, 74, 75, 71, 69, 72, 76, 73};
    OutputBasicArray1D(Solution().dailyTemperatures(t));

    return 0;
}
