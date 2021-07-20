// Created by WXX on 2021/7/20 17:44
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

/**
 * 执行用时：24 ms, 在所有 C++ 提交中击败了69.41%的用户
 * 内存消耗：23.8 MB, 在所有 C++ 提交中击败了69.25%的用户
 */
class Solution {
public:
    vector<int> constructArr(vector<int> &a) {
        int n = a.size();
        // (1) 计算前缀积
        vector<int> res(n, 1);
        for (int i = 1; i < n; i++) res[i] = res[i - 1] * a[i - 1];
        // (2) 计算后缀积s，并计算最终答案
        for (int i = n - 1, s = 1; i >= 0; i--) res[i] *= s, s *= a[i];

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

    vector<int> a = {1, 2, 3, 4, 5};
    OutputBasicArray1D(Solution().constructArr(a));

    return 0;
}
