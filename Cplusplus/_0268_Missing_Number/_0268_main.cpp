// Created by WXX on 2021/1/29 20:32
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：24 ms, 在所有 C++ 提交中击败了89.91%的用户
 * 内存消耗：17.5 MB, 在所有 C++ 提交中击败了92.39%的用户
 */
class Solution {
public:
    int missingNumber(vector<int> &nums) {

        int n = nums.size();
        int res = n * (n + 1) / 2;
        for (auto x : nums) res -= x;
        return res;
    }
};

int main() {

    vector<int> nums = {3, 0, 1};
    cout << Solution().missingNumber(nums) << endl;  // 2

    return 0;
}
