// Created by WXX on 2021/7/20 9:23
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    int minPairSum(vector<int> &nums) {
        sort(nums.begin(), nums.end());
        int i = 0, j = nums.size() - 1;
        int res = 0;
        while (i < j) res = max(res, nums[i++] + nums[j--]);
        return res;
    }
};

int main() {

    vector<int> nums = {3, 5, 2, 3};
    cout << Solution().minPairSum(nums) << endl;  // 7

    return 0;
}
