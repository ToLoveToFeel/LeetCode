// Created by WXX on 2021/7/19 16:59
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

/**
 * 执行用时：12 ms, 在所有 C++ 提交中击败了46.18%的用户
 * 内存消耗：10.8 MB, 在所有 C++ 提交中击败了82.76%的用户
 */
class Solution {
public:
    string minNumber(vector<int> &nums) {
        sort(nums.begin(), nums.end(), [](int x, int y) {
            string a = to_string(x), b = to_string(y);
            return a + b < b + a;
        });
        string res;
        for (auto x : nums) res += to_string(x);
        return res;
    }
};

int main() {

    vector<int> nums = {10, 2};
    cout << Solution().minNumber(nums) << endl;  // 102

    return 0;
}
