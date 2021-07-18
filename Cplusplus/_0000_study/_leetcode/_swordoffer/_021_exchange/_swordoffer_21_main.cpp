// Created by WXX on 2021/7/18 17:01
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    vector<int> exchange(vector<int> &nums) {
        int n = nums.size();
        vector<int> res(n, 0);
        for (int i = 0, j = 0, k = n - 1; i < n; i++)
            if (nums[i] % 2) res[j++] = nums[i];
            else res[k--] = nums[i];
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

    vector<int> nums = {1, 2, 3, 4};
    OutputBasicArray1D(Solution().exchange(nums));  // [1, 3, 4, 2]

    return 0;
}
