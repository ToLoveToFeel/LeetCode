// Created by WXX on 2021/1/22.
#include <iostream>
#include <vector>

using namespace std;

// 动态规划
/**
 * 时间复杂度：O(n)       空间复杂度：O(1)
 * 执行用时：4 ms, 在所有 C++ 提交中击败了97.99%的用户
 * 内存消耗：11.4 MB, 在所有 C++ 提交中击败了97.84%的用户
 */
class Solution {
public:
    int maxProduct(vector<int>& nums) {

        int res = nums[0];
        int f = nums[0], g = nums[0];  // f存储以当前考察元素为结尾的连续数组乘积最大值，g存储最小值
        for (int i = 1; i < nums.size(); i++) {
            int a = nums[i], fa = f * a, ga = g * a;
            f = max(a, max(fa, ga));
            g = min(a, min(fa, ga));
            res = max(res, f);
        }
        return res;
    }
};

int main() {

    vector<int> nums = {2, 3, -2, 4};  // 6
    cout << Solution().maxProduct(nums) << endl;

    return 0;
}