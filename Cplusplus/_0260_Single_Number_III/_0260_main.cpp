// Created by WXX on 2021/1/29 20:04
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int get(vector<int> &nums, int k, int t) {

        int res = 0;
        for (auto x : nums)
            if ((x >> k & 1) == t)
                res ^= x;
        return res;
    }

    vector<int> singleNumber(vector<int> &nums) {

        int ab = 0;
        for (auto x : nums) ab ^= x;
        int k = 0;
        while ((ab >> k & 1) == 0) k++;
        return {get(nums, k, 0), get(nums, k, 1)};
    }
};

void OutputBasicArray1D(vector<int> &nums) {
    cout << "[";
    for (int i = 0; i < nums.size(); i++) {
        cout << nums[i];
        if (i != nums.size() - 1) cout << ", ";
    }
    cout << "]" << endl;
}

int main() {

    vector<int> nums = {1, 2, 1, 3, 2, 5};
    vector<int> res = Solution().singleNumber(nums);
    OutputBasicArray1D(res);  // [5, 3]

    return 0;
}
