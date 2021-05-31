// Created by WXX on 2021/5/31 19:37
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：4 ms, 在所有 C++ 提交中击败了94.69%的用户
 * 内存消耗：8.8 MB, 在所有 C++ 提交中击败了52.94%的用户
 */
class Solution {
public:
    int thirdMax(vector<int> &nums) {
        long long a = -1e10, b = -1e10, c = -1e10, s = 0;
        for (auto x : nums) {
            if (x > a) s++, c = b, b = a, a = x;
            else if (x < a && x > b) s++, c = b, b = x;
            else if (x < b && x > c) s++, c = x;
        }
        if (s < 3) return a;
        return c;
    }
};

int main() {

    vector<int> nums = {1, 2, 3};
    cout << Solution().thirdMax(nums) << endl;  // 1

    return 0;
}
