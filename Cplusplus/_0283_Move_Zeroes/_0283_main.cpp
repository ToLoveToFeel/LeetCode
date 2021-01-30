// Created by WXX on 2021/1/30 17:27
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    void moveZeroes(vector<int> &nums) {

        int k = 0;
        for (int i = 0; i < nums.size(); i++)
            if (nums[i] != 0)
                nums[k++] = nums[i];

        while (k < nums.size()) nums[k++] = 0;
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

    vector<int> nums = {0, 1, 0, 3, 12};
    Solution().moveZeroes(nums);
    OutputBasicArray1D(nums);

    return 0;
}
