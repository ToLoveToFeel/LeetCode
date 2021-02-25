// Created by WXX on 2021/2/25 10:42
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：12 ms, 在所有 C++ 提交中击败了67.50%的用户
 * 内存消耗：10.9 MB, 在所有 C++ 提交中击败了99.81%的用户
 */
class Solution {
public:
    int minPatches(vector<int> &nums, int n) {

        long long x = 1;
        int i = 0, res = 0;
        while (x <= n) {
            if (i < nums.size() && nums[i] <= x) x += nums[i++];
            else {
                x += x;
                res++;
            }
        }
        return res;
    }
};

int main() {

    vector<int> nums = {1, 3};
    int n = 6;
    cout << Solution().minPatches(nums, n) << endl;  // 1

    return 0;
}
