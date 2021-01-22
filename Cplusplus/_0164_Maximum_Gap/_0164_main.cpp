// Created by WXX on 2021/1/22 17:21
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：8 ms, 在所有 C++ 提交中击败了97.57%的用户
 * 内存消耗：8.7 MB, 在所有 C++ 提交中击败了88.89%的用户
 */
class Solution {
public:
    int maximumGap(vector<int> &nums) {

        struct Range {
            int min, max;  // 记录落入区间(l, r]的最小值、最大值
            bool used;  // 记录这个区间中是否存在数据
            Range() : min(INT_MAX), max(INT_MIN), used(false) {}
        };

        int n = nums.size();
        int Min = INT_MAX, Max = INT_MIN;  // 数组中最小值和最大值
        for (auto x : nums) Min = min(Min, x), Max = max(Max, x);

        if (n < 2 || Min == Max) return 0;

        vector<Range> r(n - 1);  // n个数据最多n-1个区间
        int len = (Max - Min + n - 2) / (n - 1);
        for (auto x : nums) {
            if (x == Min) continue;  // 最小值不属于任何一个区间，因为左开右闭
            int k = (x - Min - 1) / len;  // 计算x属于哪个区间
            r[k].used = true;
            r[k].min = min(r[k].min, x);
            r[k].max = max(r[k].max, x);
        }

        int res = 0;
        for (int i = 0, last = Min; i < n - 1; i++) {
            if (r[i].used) {
                res = max(res, r[i].min - last);
                last = r[i].max;
            }
        }
        return res;
    }
};

int main() {

    vector<int> nums = {3, 6, 9, 1};
    cout << Solution().maximumGap(nums) << endl;

    return 0;
}
