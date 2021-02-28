// Created by WXX on 2021/2/25 21:09
#include <iostream>
#include <vector>

using namespace std;

// 递推
/**
 * 执行用时：8 ms, 在所有 C++ 提交中击败了61.87%的用户
 * 内存消耗：7.6 MB, 在所有 C++ 提交中击败了92.20%的用户
 */
class Solution {
public:
    vector<int> countBits(int num) {

        vector<int> f(num + 1);
        for (int i = 1; i <= num; i++)
            f[i] = f[i >> 1] + (i & 1);
        return f;
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

    OutputBasicArray1D(Solution().countBits(2));  // [0, 1, 1]
    OutputBasicArray1D(Solution().countBits(5));  // [0, 1, 1, 2, 1, 2]

    return 0;
}
