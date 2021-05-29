// Created by WXX on 2021/5/29 21:13
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:

    vector<int> a;

    Solution(vector<int>& nums) {
        a = nums;
    }

    /** Resets the array to its original configuration and return it. */
    vector<int> reset() {
        return a;
    }

    /** Returns a random shuffling of the array. */
    vector<int> shuffle() {
        vector<int> b = a;
        int n = a.size();
        for (int i = 0; i < n; i++)
            swap(b[i], b[i + rand() % (n - i)]);
        return b;
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

    vector<int> nums = {1, 2, 3};
    OutputBasicArray1D(Solution(nums).shuffle());
    OutputBasicArray1D(Solution(nums).shuffle());
    OutputBasicArray1D(Solution(nums).shuffle());

    return 0;
}
