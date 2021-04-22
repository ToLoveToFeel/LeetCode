// Created by WXX on 2021/4/22 17:24
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    int threeSumClosest(vector<int> &nums, int target) {

        sort(nums.begin(), nums.end());

        pair<int, int> res(INT_MAX, INT_MAX);  // (三数之和与target的差值的绝对值, 三数之和)
        for (int i = 0; i < nums.size(); i++)
            for (int j = i + 1, k = nums.size() - 1; j < k; j++) {
                while (j < k - 1 && nums[i] + nums[j] + nums[k - 1] >= target) k--;
                int s = nums[i] + nums[j] + nums[k];
                res = min(res, make_pair(abs(s - target), s));
                if (j < k - 1) {
                    s = nums[i] + nums[j] + nums[k - 1];
                    res = min(res, make_pair(abs(s - target), s));
                }
            }
        return res.second;
    }
};

int main() {

    vector<int> nums = {-1, 2, 1, -4};
    cout << Solution().threeSumClosest(nums, 1) << endl;  // 2

    return 0;
}
