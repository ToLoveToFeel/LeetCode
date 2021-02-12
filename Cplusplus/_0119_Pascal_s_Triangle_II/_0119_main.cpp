// Created by WXX on 2021/2/12 14:09
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：4 ms, 在所有 C++ 提交中击败了36.05%的用户
 * 内存消耗：6.2 MB, 在所有 C++ 提交中击败了91.77%的用户
 */
class Solution {
public:
    vector<int> getRow(int n) {  // 从第0行开始

        vector<int> res(n + 1, 1);
        for (int i = 1; i <= n; i++)
            res[i] = (long long)res[i - 1] * (n - i + 1) / i;
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

    OutputBasicArray1D(Solution().getRow(0));
    OutputBasicArray1D(Solution().getRow(33));

    return 0;
}
