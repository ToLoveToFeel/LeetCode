// Created by WXX on 2021/4/23 9:11
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

/**
 * 执行用时：60 ms, 在所有 C++ 提交中击败了37.37%的用户
 * 内存消耗：8.5 MB, 在所有 C++ 提交中击败了65.69%的用户
 */
class Solution {
public:
    vector<int> largestDivisibleSubset(vector<int> &nums) {

        sort(nums.begin(), nums.end());
        int n = nums.size();
        vector<int> f(n);
        int k = 0;  // 记录f最大时的下标，即f[k]最大
        for (int i = 0; i < n; i++) {
            f[i] = 1;
            for (int j = i - 1; j >= 0; j--)
                if (nums[i] % nums[j] == 0)
                    f[i] = max(f[i], f[j] + 1);
            if (f[k] < f[i]) k = i;
        }

        // 反向递推出答案
        vector<int> res(1, nums[k]);
        while (f[k] > 1) {
            for (int i = 0; i < k; i++)
                if (nums[k] % nums[i] == 0 && f[k] == f[i] + 1) {
                    res.push_back(nums[i]);
                    k = i;
                    break;
                }
        }
        return res;
    }
};

int main() {


    return 0;
}
