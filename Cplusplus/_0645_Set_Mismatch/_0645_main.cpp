// Created by WXX on 2021/7/4 11:34
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    vector<int> findErrorNums(vector<int> &nums) {
        vector<int> res(2);
        for (auto x : nums) {
            int k = abs(x);
            if (nums[k - 1] < 0) res[0] = k;
            nums[k - 1] *= -1;
        }
        for (int i = 0; i < nums.size(); i++)
            if (nums[i] > 0 && i + 1 != res[0]) {
                res[1] = i + 1;
                break;
            }
        return res;
    }
};

void OutputBasicArray1D(vector<int> nums) {
    cout << "[";
    for (int i = 0; i < nums.size(); i++) {
        cout << nums[i];
        if (i != nums.size() - 1) cout << ", ";
    }
    cout << "]" << endl;
}

int main() {

    vector<int> nums = {1, 2, 2, 4};
    OutputBasicArray1D(Solution().findErrorNums(nums));  // [2, 3]

    return 0;
}
