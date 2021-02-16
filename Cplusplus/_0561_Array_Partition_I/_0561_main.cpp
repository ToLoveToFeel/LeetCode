// Created by WXX on 2021/2/16 8:57
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    int arrayPairSum(vector<int> &nums) {

        sort(nums.begin(), nums.end());
        int res = 0;
        for (int i = 0; i < nums.size(); i += 2) res += nums[i];
        return res;
    }
};

int main() {

    vector<int> nums = {1, 4, 3, 2};
    cout << Solution().arrayPairSum(nums) << endl;  // 4

    return 0;
}
